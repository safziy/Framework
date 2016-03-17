package com.safziy.guice.module;

import com.google.inject.Inject;

public class MySecondService {

	private MyFirstService myFirstService;

	@Inject
	public MySecondService(MyFirstService myFirstService) {
		this.myFirstService = myFirstService;
		System.out.println("MyObjectContainer constructor myFirstService=" + myFirstService);
	}

	@Override
	public String toString() {
		return super.toString() + " [myFirstService=" + myFirstService + "]";
	}

}
