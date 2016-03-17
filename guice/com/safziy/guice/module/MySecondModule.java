package com.safziy.guice.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class MySecondModule extends AbstractModule {

	@Override
	protected void configure() {
		System.out.println("MySecondModule configure()");
		bind(MyObjectContainer.class).in(Singleton.class);
	}

}
