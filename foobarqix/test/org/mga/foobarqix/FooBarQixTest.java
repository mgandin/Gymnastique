package org.mga.foobarqix;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class FooBarQixTest {

	private FooBarQix fooBarQix;
	private String matched;
	
	@Before	public void setUp() {
		this.fooBarQix = new FooBarQix();
	}

	@Test public void shouldNotMatch() {
		assertMatch(1,"1");
		assertMatch(2,"2");

	}
	
	@Test public void shouldMatchSimpleDigit() {
		assertMatch(3,"FooFoo");
		assertMatch(5,"BarBar");
		assertMatch(7,"QixQix");
	}

	@Test public void shouldMatchMultipleDigit() {
		assertMatch(13, "Foo");
		assertMatch(17, "Qix");	
		assertMatch(52, "Bar");	
		assertMatch(23, "Foo");	
		assertMatch(37, "FooQix");	
		assertMatch(337, "FooFooQix");	

	}
	
	@Test public void shouldMatchDivisors() {
		assertMatch(6,"Foo");
		assertMatch(9,"Foo");
		assertMatch(10,"Bar");
		assertMatch(14,"Qix");
		assertMatch(21,"FooQix");
	}
	
	@Test public void shouldMatchBoth() {
		assertMatch(35,"BarQixFooBar");
	}
	
	private void assertMatch(int toMatche,String toVerify) {
		matched = fooBarQix.match(toMatche);
		Assert.assertEquals(toVerify, matched);
	}
}
