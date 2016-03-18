package com.safziy.guice.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Singleton;

@Singleton
public class MyFirstServlet extends HttpServlet {

	private static final long serialVersionUID = -4539247220779892759L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("MyFirstServlet doGet(HttpServletRequest req, HttpServletResponse resp)");
		resp.getWriter().append("MyFirstServlet doGet(HttpServletRequest req, HttpServletResponse resp)");
//		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}
