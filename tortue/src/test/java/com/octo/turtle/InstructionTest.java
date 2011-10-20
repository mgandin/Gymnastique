package com.octo.turtle;

import junit.framework.Assert;

import org.junit.Test;


public class InstructionTest {

	private Instruction instruction = new Instruction();
	
	@Test
	public void ShouldSelectPen() {
		String instructionExecuted = instruction.selectPen();
		Assert.assertEquals("P", instructionExecuted);
	}
	
	@Test
	public void shouldDoPenUp() {
		String instructionExecuted = instruction.doPenUp();
		Assert.assertEquals("^", instructionExecuted);
	}
	
	@Test
	public void shoudDoPenDown() {
		String instructionExecuted = instruction.doPenDown();
		Assert.assertEquals("v", instructionExecuted);
	}
	
	@Test
	public void shouldGoNorthWithOneAndTwoWalk() {
		String instructionExecuted = instruction.writeInNorthWith(1);
		Assert.assertEquals("^\n|", instructionExecuted);
		
		instructionExecuted = instruction.writeInNorthWith(2);
		Assert.assertEquals("^\n|\n|", instructionExecuted);
	}
	
	@Test
	public void shouldGoSouthWithOneAndTwoWalk() {
		String instructionExecuted = instruction.writeInSouthWith(1);
		Assert.assertEquals("|\nv", instructionExecuted);
		
		instructionExecuted = instruction.writeInSouthWith(2);
		Assert.assertEquals("|\n|\nv", instructionExecuted);
	}
	
	@Test
	public void shouldGoEastWithOneAndTwoWalk() {
		String instructionExecuted = instruction.writeInEastWith(1);
		Assert.assertEquals("->", instructionExecuted);

		instructionExecuted = instruction.writeInEastWith(2);
		Assert.assertEquals("-->", instructionExecuted);

	}
	
	@Test
	public void shouldGoWestWithOneAndTwoWalk() {
		String instructionExecuted = instruction.writeInWestWith(1);
		Assert.assertEquals("<-", instructionExecuted);

		instructionExecuted = instruction.writeInWestWith(2);
		Assert.assertEquals("<--", instructionExecuted);

	}
}
