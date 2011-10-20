package com.octo.turtle;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Instructions {

	private Instruction instruction;
	private Map<String,Method> mapOfInstructions;
	private Map<String,Method> mapOfInstructionsWithArgs;

	
	public Instructions(Instruction instruction) {
		this.instruction = instruction;
		init();
	}

	private void init() {
		mapOfInstructions = new HashMap<String, Method>();
		mapOfInstructionsWithArgs = new HashMap<String, Method>();

		try {
			mapOfInstructions.put("P",instruction.getClass().getMethod("selectPen", null));
			mapOfInstructions.put("U",instruction.getClass().getMethod("doPenUp", null));
			mapOfInstructions.put("D",instruction.getClass().getMethod("doPenDown", null));
			mapOfInstructionsWithArgs.put("N", instruction.getClass().getMethod("writeInNorthWith", Integer.class));
			mapOfInstructionsWithArgs.put("S", instruction.getClass().getMethod("writeInSouthWith", Integer.class));
			mapOfInstructionsWithArgs.put("E", instruction.getClass().getMethod("writeInEastWith", Integer.class));
			mapOfInstructionsWithArgs.put("W", instruction.getClass().getMethod("writeInWestWith", Integer.class));
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);

		}
	}

	public Method getMethod(String command) {
		return mapOfInstructions.get(command);
	}

	public Method getMethodWithArg(String command) {
		return mapOfInstructionsWithArgs.get(command);
	}

}
