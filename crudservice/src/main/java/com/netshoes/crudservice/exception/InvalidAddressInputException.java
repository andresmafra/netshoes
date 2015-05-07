package com.netshoes.crudservice.exception;

/**
 * Exception for address that already exists
 * 
 * @author andre.s.mafra
 * 
 */
public class InvalidAddressInputException extends Exception {

	/**
	 * Serial uuid
	 */
	private static final long serialVersionUID = -415475668500508447L;

	public InvalidAddressInputException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidAddressInputException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidAddressInputException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidAddressInputException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidAddressInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
