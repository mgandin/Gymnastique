package com.octo.turtle;

public class Command {

	private String command;
	private String instruction;
	private Integer args;
	private Boolean hasArgs = Boolean.FALSE;
	public Command(String command) {
		this.command = command;
	}

	public void parse() {
		instruction = command.substring(0, 1);
		if(command.length() > 1) {
			args = new Integer(command.substring(2,3));
			hasArgs = Boolean.TRUE;
		}
	}

	public String getInstruction() {
		return this.instruction;
	}

	public Boolean hasArgs() {
		return this.hasArgs;
	}

	public Integer getArgs() {
		return this.args;
	}

}
