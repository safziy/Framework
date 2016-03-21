package com.safziy.java.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {

	private AsynchronousSocketChannel asynchronousSocketChannel;

	public ReadCompletionHandler(AsynchronousSocketChannel asynchronousSocketChannel) {
		if (asynchronousSocketChannel == null) {
			this.asynchronousSocketChannel = asynchronousSocketChannel;
		}
	}

	@Override
	public void completed(Integer result, ByteBuffer attachment) {
		attachment.flip();
		byte[] bytes = new byte[attachment.remaining()];
		attachment.get(bytes);
		String resvMsg = new String(bytes);
		System.out.println("echo server receive message: " + resvMsg);
		String respMsg = "receive your message success {" + resvMsg + "}\n";
		byte[] responeBytes = respMsg.getBytes();
		ByteBuffer responeByteBuffer = ByteBuffer.allocate(responeBytes.length);
		responeByteBuffer.put(responeBytes);

		asynchronousSocketChannel.write(responeByteBuffer, responeByteBuffer,
				new CompletionHandler<Integer, ByteBuffer>() {

					@Override
					public void completed(Integer result, ByteBuffer attachment) {
						if(attachment.hasRemaining()){
							asynchronousSocketChannel.write(attachment, attachment, this);
						}
					}

					@Override
					public void failed(Throwable exc, ByteBuffer attachment) {
						try {
							asynchronousSocketChannel.close();
						} catch (IOException e) {
						}
					}
				});
	}

	@Override
	public void failed(Throwable exc, ByteBuffer attachment) {

	}

}
