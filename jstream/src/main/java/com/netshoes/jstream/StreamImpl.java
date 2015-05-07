package com.netshoes.jstream;

import java.util.ArrayList;
import java.util.List;

/**
 * StreamImpl is a implementation of the Stream interface
 * 
 * @author andre.s.mafra
 * 
 */
public class StreamImpl implements Stream {

	/**
	 * Input of chars
	 */
	private String input;

	/**
	 * Char that was read by the system
	 */
	private List<Character> charRead;

	/**
	 * Last read index
	 */
	private int lastIndex = -1;

	/**
	 * Constructor
	 * 
	 * @param input
	 */
	public StreamImpl(String input) {
		this.input = input;
		charRead = new ArrayList<Character>(1);
	}

	/**
	 * @see Stream
	 */
	public char getNext() {
		char next = input.charAt(++lastIndex);
		charRead.add(next);
		return next;
	}

	/**
	 * @see Stream
	 */
	public boolean hasNext() {

		try {
			input.charAt(lastIndex + 1);
			return true;
		} catch (IndexOutOfBoundsException ex) {
		}

		return false;
	}

}
