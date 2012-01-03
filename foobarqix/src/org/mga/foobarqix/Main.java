package org.mga.foobarqix;

public class Main {

	public static void main(String[] args) {

		FooBarQix fooBarQix = new FooBarQix();
		for (int i = 1; i <= 100; i++) {
			System.out.println(fooBarQix.match(i));
		}
	}

}
