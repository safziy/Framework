package com.safziy.java.nio;

public class NIOLauncher {
	public static void main(String[] args) {
		new Thread(new NIOEchoServer(11111)).start();
	}
}
