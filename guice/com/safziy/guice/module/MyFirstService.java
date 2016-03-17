package com.safziy.guice.module;

import com.google.inject.Inject;

public class MyFirstService {

	private MySecondService mySecondService;

	@Inject
	public MyFirstService(MySecondService mySecondService) {
		this.mySecondService = mySecondService;
		System.out.println("MyFirstService constructor myObject" + mySecondService);
	}

	@Override
	public String toString() {
		return super.toString() + " [mySecondService=" + mySecondService + "]";
	}

}
