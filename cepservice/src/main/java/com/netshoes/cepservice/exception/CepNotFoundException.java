package com.netshoes.cepservice.exception;

/**
 * Exception class for cep not found on database
 * 
 * @author andre.s.mafra
 * 
 */
public class CepNotFoundException extends Exception {

	/**
	 * Serial uuid
	 */
	private static final long serialVersionUID = -2164604850689074960L;

	public CepNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public CepNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CepNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public CepNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CepNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
