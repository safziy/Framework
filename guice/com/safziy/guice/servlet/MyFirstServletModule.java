package com.safziy.guice.servlet;

import com.google.inject.servlet.ServletModule;

public class MyFirstServletModule extends ServletModule {
	@Override
	protected void configureServlets() {
		System.out.println("MyFirstServletModule configureServlets()");
		serve("/firstservlet").with(MyFirstServlet.class);
	}
}
