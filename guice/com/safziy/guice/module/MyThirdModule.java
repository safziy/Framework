package com.safziy.guice.module;

import com.google.inject.AbstractModule;

public class MyThirdModule extends AbstractModule {

	@Override
	protected void configure() {
		System.out.println("MyThirdModule configure()");
		// ���´�������ѭ������
		// bind(MyFirstService.class).in(Singleton.class);
		// bind(MySecondService.class).in(Singleton.class);
	}

}
