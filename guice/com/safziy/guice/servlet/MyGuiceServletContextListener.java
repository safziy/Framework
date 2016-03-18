package com.safziy.guice.servlet;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import com.google.inject.servlet.GuiceServletContextListener;

public class MyGuiceServletContextListener extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		System.out.println("MyGuiceServletContextListener getInjector()");
		return Guice.createInjector(Stage.PRODUCTION, new MyFirstServletModule());
	}

}
