package com.netshoes.crudservice.exception;

/**
 * Generic errors exception class
 * 
 * @author andre.s.mafra
 * 
 */
public class GenericAPIException extends Exception {

	/**
	 * Serial uuid
	 */
	private static final long serialVersionUID = 8427546735343168018L;

	public GenericAPIException() {
		// TODO Auto-generated constructor stub
	}

	public GenericAPIException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public GenericAPIException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public GenericAPIException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public GenericAPIException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
