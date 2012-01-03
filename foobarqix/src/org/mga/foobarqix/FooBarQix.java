package org.mga.foobarqix;


public class FooBarQix {

	private static final String FOO = "Foo";
	private static final String BAR = "Bar";
	private static final String QIX = "Qix";
	
	public String match(Integer toCompute) {
		StringBuffer accumulator = new StringBuffer();

		accumulator.append(appendIfDivisor(FOO, 3, toCompute));
		accumulator.append(appendIfDivisor(BAR, 5, toCompute));
		accumulator.append(appendIfDivisor(QIX, 7, toCompute));
			
		String[] toComputeAsString = toCompute.toString().split("");
		for (String string : toComputeAsString) {
			accumulator.append(computeOneDigit(string));	
		}
		if("".equals(accumulator.toString()))
			accumulator.append(toCompute);
		return accumulator.toString();
	}
	
	private String appendIfDivisor(String suffix,Integer divisor, Integer toCompute) {
		if(toCompute % divisor == 0)
			return suffix;
		return "";
	}
	private String appendIfContains(String suffix,String digit, String toCompute) {
		if(toCompute.contains(digit))
			return suffix;
		return "";
	}
	
	private String computeOneDigit(String toCompute) {
		StringBuffer accumulator = new StringBuffer();
		accumulator.append(appendIfContains(FOO,"3",toCompute));
		accumulator.append(appendIfContains(BAR,"5",toCompute));
		accumulator.append(appendIfContains(QIX,"7",toCompute));
		return accumulator.toString();
	}

	
}
