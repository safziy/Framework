package com.safziy.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOEchoServer implements Runnable {
	private Selector selector = null;
	private ServerSocketChannel serverSocketChannel;
	private volatile boolean stop = false;

	public NIOEchoServer(int port) {
		try {
			selector = Selector.open();
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.socket().bind(new InetSocketAddress("localhost", port), 1024);
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("The nioEchoServer start at port " + port);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		while (!stop) {
			try {
				selector.select();
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = keys.iterator();
				while (iterator.hasNext()) {
					SelectionKey key = iterator.next();
					if (key.isValid()) {
						if (key.isAcceptable()) {
							ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
							SocketChannel sc = ssc.accept();
							sc.configureBlocking(false);
							sc.register(selector, SelectionKey.OP_READ);
							iterator.remove();
						} else if (key.isReadable()) {
							SocketChannel sc = (SocketChannel) key.channel();
							ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
							int readBytes = sc.read(byteBuffer);
							if(readBytes > 0){
								byteBuffer.flip();
								byte[] bytes = new byte[byteBuffer.remaining()];
								byteBuffer.get(bytes);
								String resvMsg = new String(bytes);
								System.out.println("echo server receive message: " + resvMsg);
								String respMsg = "receive your message success {" + resvMsg + "}\n";
								byte[] responeBytes = respMsg.getBytes();
								ByteBuffer responeByteBuffer = ByteBuffer.allocate(responeBytes.length);
								responeByteBuffer.put(responeBytes);
								responeByteBuffer.flip();
								sc.write(responeByteBuffer);
							}else if(readBytes < 0){
								System.out.println("client closed ... ");
								iterator.remove();
								sc.close();
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (selector != null) {
			try {
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
