package com.safziy.guice.module;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;

public class ModuleTest {

	@Test
	public void testMyModule() {
		Injector injector = Guice.createInjector(Stage.PRODUCTION, new MyFisrtModule(), new MySecondModule(),
				new MyThirdModule(), new MyFourModule());
		System.out.println("before getInstance...");
		MyObjectContainer myObjectContainer = injector.getInstance(MyObjectContainer.class);
		System.out.println("after getInstance...");
		System.out.println(myObjectContainer);

		MyObjectContainer myObjectContainer2 = injector.getInstance(MyObjectContainer.class);
		System.out.println(myObjectContainer2);

		MyThirdService myThirdService = injector.getInstance(MyThirdService.class);
		System.out.println(myThirdService);
		
		MyThirdService myThirdService1 = injector.getInstance(MyThirdService.class);
		System.out.println(myThirdService1);
	}
}
