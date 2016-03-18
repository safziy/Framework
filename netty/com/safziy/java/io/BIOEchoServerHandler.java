package com.safziy.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class BIOEchoServerHandler implements Runnable {
	Socket socket;

	public BIOEchoServerHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while (true) {
				String resvMsg = reader.readLine();
				System.out.println("echo server receive message: " + resvMsg);
				String respMsg = "receive your message success {" + resvMsg + "}\n";
				writer.write(respMsg);
				writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
