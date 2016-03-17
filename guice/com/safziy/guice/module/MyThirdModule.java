package com.safziy.guice.module;

import com.google.inject.AbstractModule;

public class MyThirdModule extends AbstractModule {

	@Override
	protected void configure() {
		System.out.println("MyThirdModule configure()");
		// 以下代码会产生循环依赖
		// bind(MyFirstService.class).in(Singleton.class);
		// bind(MySecondService.class).in(Singleton.class);
	}

}
