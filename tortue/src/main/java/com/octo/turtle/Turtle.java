package com.octo.turtle;

import java.io.IOException;

public class Turtle {

	public static void main(String[] args) throws IOException {
		Interpreter interpreter = new Interpreter(new Instructions(new Instruction()));
		System.out.println(interpreter.execute(new Command(args[0])));
	}

}
