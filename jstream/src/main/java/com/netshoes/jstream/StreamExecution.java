package com.netshoes.jstream;

/**
 * Stream execution main class
 * 
 * @author andre.s.mafra
 * 
 */
public class StreamExecution {

	/**
	 * Null char constant
	 */
	static final char CHAR_NULL = 0;

	/**
	 * Main execution method
	 * 
	 * @param args
	 *            - The first index will be the input chars list as String
	 */
	public static void main(String[] args) {
		char first = firstChar(new StreamImpl(args[0]));
		System.out.println(CHAR_NULL == first ? "No different char found." : "First non repeatable char -> " + first);
	}

	/**
	 * This method gets the first different char in a input
	 * 
	 * @param input
	 *            chars input stream list
	 * @return
	 */
	public static char firstChar(Stream input) {

		char firstDifferent = CHAR_NULL;
		char last = CHAR_NULL;

		while (input.hasNext()) {

			char actual = input.getNext();

			if (last != 0 && isDifferent(last, actual)) {
				firstDifferent = actual;
				break;
			}

			last = actual;
		}

		return firstDifferent;
	}

	/**
	 * Verify if a char is different from another
	 * 
	 * @param last
	 *            last read char
	 * @param actual
	 *            actual char read
	 * @return if both is different or not
	 */
	private static final boolean isDifferent(char last, char actual) {
		return Character.toLowerCase(last) != Character.toLowerCase(actual);
	}

}
