package com.safziy.java.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOEchoServer {
	ServerSocket serverSocket;
	
	public void bind(int port){
		try {
			serverSocket = new ServerSocket(port);
			while(true){
				Socket socket = serverSocket.accept();
				new Thread(new BIOEchoServerHandler(socket)).start();
			}
		} catch (IOException e) {
			System.err.println("start echo server fail!");
			e.printStackTrace();
		}finally{
			if(serverSocket != null){
				try {
					serverSocket.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
