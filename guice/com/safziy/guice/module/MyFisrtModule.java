package com.safziy.guice.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class MyFisrtModule extends AbstractModule {

	@Override
	protected void configure() {
		System.out.println("MyFisrtModule configure()");
	}
	
	@Provides
	public MyObject createMyObject(){
		return new MyObject(10);
	}

}
