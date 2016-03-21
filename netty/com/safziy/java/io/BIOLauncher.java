package com.safziy.java.io;

public class BIOLauncher {
	public static void main(String[] args) {
		new BIOEchoServer().bind(11221);
	}
}
