package com.octo.turtle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Turtle {

	public static void main(String[] args) throws IOException {
		
		
		while(true) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Interpreter interpreter = new Interpreter(new Instructions(new Instruction()));
			String commandAsString = reader.readLine();
			if(commandAsString.equals("q"))
				System.exit(0);
			System.out.println(interpreter.execute(new Command(commandAsString)));
		}
	}

}
