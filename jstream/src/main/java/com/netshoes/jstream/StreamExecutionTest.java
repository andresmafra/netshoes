package com.netshoes.jstream;

/**
 * StreamExecution test class
 * 
 * @author andre.s.mafra
 * 
 */
public class StreamExecutionTest {

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Test cases
		String[] cases = { "aaAAaaAAaaB" };
		StreamExecution.main(cases);

		// Test empty
		String[] empty = { "    P" };
		StreamExecution.main(empty);

		// Test numbers
		String[] numbers = { "111111110" };
		StreamExecution.main(numbers);

		// Test equals
		String[] equals = { "99999" };
		StreamExecution.main(equals);

		// Test specialChars
		String[] specialChars = { "!!!#$@^&" };
		StreamExecution.main(specialChars);
	}
}
