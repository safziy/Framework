package com.safziy.guice.module;

import com.google.inject.AbstractModule;

public class MyFourModule extends AbstractModule {

	@Override
	protected void configure() {
		System.out.println("MyFourModule configure()");
	}

}
