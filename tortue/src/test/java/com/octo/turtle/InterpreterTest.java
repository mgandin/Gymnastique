package com.octo.turtle;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class InterpreterTest {

	private Interpreter interpreter;
	
	@Before
	public void setUp() {
		interpreter = new Interpreter(new Instructions(new Instruction()));
	}
	
	@Test
	public void shouldInterpretCommandSelectPenToInstruction() {
		String instructionExecuted = interpreter.execute(new Command("P"));
		Assert.assertEquals(instructionExecuted,"P");
	}
	
	@Test
	public void shouldInterpretCommandPenUpToInstruction() {
		String instructionExecuted = interpreter.execute(new Command("U"));
		Assert.assertEquals(instructionExecuted, "^");
	}
	
	@Test
	public void shouldInterpretCommandWalkToNorthInstruction() {
		String instructionExecuted = interpreter.execute(new Command("N 1"));
		Assert.assertEquals(instructionExecuted, "^\n|");

	}
	
	@Test
	public void shouldInterpretCommandWalkToEastInstruction() {
		String instructionExecuted = interpreter.execute(new Command("E 2"));
		Assert.assertEquals(instructionExecuted, "-->");

	}
}
