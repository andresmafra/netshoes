package com.netshoes.crudservice.exception;

/**
 * Cep validation exception class
 * 
 * @author andre.s.mafra
 * 
 */
public class CepValidationException extends Exception {

	/**
	 * Serial uuid
	 */
	private static final long serialVersionUID = -7016995360609152169L;

	public CepValidationException() {
		// TODO Auto-generated constructor stub
	}

	public CepValidationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CepValidationException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public CepValidationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CepValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
