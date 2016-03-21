package com.safziy.java.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;

public class AsynchronousEchoServer implements Runnable {
	private AsynchronousServerSocketChannel aServerSocketChannel;

	public AsynchronousEchoServer(int port) {
		try {
			aServerSocketChannel = AsynchronousServerSocketChannel.open();
			aServerSocketChannel.bind(new InetSocketAddress(port));
			System.out.println("the AsynchronousEchoServer start at " + port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		aServerSocketChannel.accept(this, new AIOEchoServerHandler());
	}

	public AsynchronousServerSocketChannel getaServerSocketChannel() {
		return aServerSocketChannel;
	}
}
