package com.safziy.guice.module;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class MyFourModule extends AbstractModule {

	@Override
	protected void configure() {
		System.out.println("MyFourModule configure()");
		bind(MyThirdService.class).in(Scopes.NO_SCOPE);
	}

}
