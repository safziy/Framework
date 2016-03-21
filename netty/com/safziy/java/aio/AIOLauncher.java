package com.safziy.java.aio;

public class AIOLauncher {
	public static void main(String[] args) {
		new Thread(new AsynchronousEchoServer(11111)).start();
	}
}
