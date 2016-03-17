package com.safziy.guice.module;

public class MyObject {
	private int value;

	public MyObject(int value) {
		this.value = value;
		System.out.println("MyObject constructor value=" + value);
	}

	public void display() {
		System.out.println("MyObject display() value=" + value);
	}

	@Override
	public String toString() {
		return super.toString() + " [value=" + value + "]";
	}

}
