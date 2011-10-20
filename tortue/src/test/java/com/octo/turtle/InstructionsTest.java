package com.octo.turtle;

import java.lang.reflect.Method;

import junit.framework.Assert;

import org.junit.Test;


public class InstructionsTest {

	@Test
	public void shouldGiveCorrectMethodToExecut() throws Exception {
		Instruction instruction = new Instruction();
		Instructions instructions = new Instructions(instruction);
		Method expectedMethod = instruction.getClass().getMethod("selectPen", null);
		Assert.assertEquals(expectedMethod, instructions.getMethod("P"));
		
		expectedMethod = instruction.getClass().getMethod("doPenUp", null);
		Assert.assertEquals(expectedMethod, instructions.getMethod("U"));
		
		expectedMethod = instruction.getClass().getMethod("doPenDown", null);
		Assert.assertEquals(expectedMethod, instructions.getMethod("D"));
		
		expectedMethod = instruction.getClass().getMethod("writeInNorthWith", Integer.class);
		Assert.assertEquals(expectedMethod, instructions.getMethodWithArg("N"));

		expectedMethod = instruction.getClass().getMethod("writeInSouthWith", Integer.class);
		Assert.assertEquals(expectedMethod, instructions.getMethodWithArg("S"));
		
		expectedMethod = instruction.getClass().getMethod("writeInEastWith", Integer.class);
		Assert.assertEquals(expectedMethod, instructions.getMethodWithArg("E"));
		
		expectedMethod = instruction.getClass().getMethod("writeInWestWith", Integer.class);
		Assert.assertEquals(expectedMethod, instructions.getMethodWithArg("W"));
	}
}
