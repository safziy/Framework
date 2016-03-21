package com.safziy.java.aio;

import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AIOEchoServerHandler implements CompletionHandler<AsynchronousSocketChannel, AsynchronousEchoServer> {

	@Override
	public void completed(AsynchronousSocketChannel result, AsynchronousEchoServer attachment) {
		attachment.getaServerSocketChannel().accept(attachment, this);
	}

	@Override
	public void failed(Throwable exc, AsynchronousEchoServer attachment) {

	}

}
