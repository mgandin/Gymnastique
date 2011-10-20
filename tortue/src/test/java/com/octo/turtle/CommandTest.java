package com.octo.turtle;

import junit.framework.Assert;

import org.junit.Test;



public class CommandTest {

	@Test
	public void shouldParseCommand() {
		Command command = new Command("P");
		command.parse();
		Assert.assertEquals("P", command.getInstruction());
		Assert.assertFalse(command.hasArgs());
		
		command = new Command("N 1");
		command.parse();
		Assert.assertEquals("N", command.getInstruction());
		Assert.assertTrue(command.hasArgs());
		Assert.assertEquals(new Integer(1), command.getArgs());
	}
}
