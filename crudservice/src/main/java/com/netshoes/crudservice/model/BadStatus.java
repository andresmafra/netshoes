package com.netshoes.crudservice.model;

import java.io.Serializable;

/**
 * Class for bad status response
 * 
 * @author andre.s.mafra
 * 
 */
public class BadStatus implements Serializable {

	/**
	 * Serial uuid
	 */
	private static final long serialVersionUID = -8057035661381180402L;

	/**
	 * Empty constructor
	 */
	public BadStatus() {
		super();
	}

	/**
	 * Constructor with status message
	 * 
	 * @param statusMessage
	 */
	public BadStatus(String statusMessage) {
		super();
		this.statusMessage = statusMessage;
	}

	/**
	 * Bad status message
	 */
	private String statusMessage;

	/**
	 * @return the statusMessage
	 */
	public String getStatusMessage() {
		return statusMessage;
	}

	/**
	 * @param statusMessage
	 *            the statusMessage to set
	 */
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

}
