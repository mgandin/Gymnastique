package com.octo.turtle;

public class Instruction {

	private static final String PEN_DOWN_INSTRUCTION = "v";
	private static final String PEN_UP_INSTRUCTION = "^";
	private static final String SELECT_PEN_INSTRUCTION = "P";

	public String selectPen() {
		return SELECT_PEN_INSTRUCTION;
	}

	public String doPenUp() {
		return PEN_UP_INSTRUCTION;
	}

	public String doPenDown() {
		return PEN_DOWN_INSTRUCTION;
	}

	public String writeInNorthWith(Integer walk) {
		return "^" + walkTheWalk(walk,"\n|").toString();
	}

	public String writeInEastWith(Integer walk) {
		return walkTheWalk(walk, "-") + ">";
	}
	
	public String writeInWestWith(Integer walk) {
		return "<" + walkTheWalk(walk, "-");
	}

	public String writeInSouthWith(Integer walk) {
		return walkTheWalk(walk, "|\n") + "v";
	}

	private StringBuffer walkTheWalk(Integer walk,String move) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < walk; i++) {
			result.append(move);
		}
		return result;
	}

	
}
