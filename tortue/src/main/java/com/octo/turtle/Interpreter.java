package com.octo.turtle;

import java.lang.reflect.InvocationTargetException;


public class Interpreter {

	private Instructions instructions;
	
	public Interpreter(Instructions instructions) {
		this.instructions = instructions;
	}

	public String execute(Command command) {
		try {
			command.parse();
			if(command.hasArgs())
				return (String)instructions.getMethodWithArg(command.getInstruction()).invoke(new Instruction(),command.getArgs());
			return (String)instructions.getMethod(command.getInstruction()).invoke(new Instruction());
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

}
