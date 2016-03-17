package com.safziy.guice.module;

import com.google.inject.Inject;

public class MyObjectContainer {

	private MyObject myObject;

	@Inject
	public MyObjectContainer(MyObject myObject) {
		this.myObject = myObject;
		System.out.println("MyObjectContainer constructor myObject" + myObject);
	}

	@Override
	public String toString() {
		return super.toString() + " [myObject=" + myObject + "]";
	}

}
