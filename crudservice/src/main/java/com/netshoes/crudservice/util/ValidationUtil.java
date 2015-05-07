package com.netshoes.crudservice.util;

import org.apache.commons.lang3.StringUtils;

import com.netshoes.crudservice.exception.InvalidAddressInputException;
import com.netshoes.crudservice.model.Endereco;

public class ValidationUtil {

	/**
	 * Avoid instantiation
	 */
	private ValidationUtil() {
	}

	public static final void validateInput(Endereco endereco) throws InvalidAddressInputException {
		
		if(endereco == null ||
				StringUtils.isBlank(endereco.getCep()) ||
				StringUtils.isBlank(endereco.getCidade()) ||
				StringUtils.isBlank(endereco.getEstado()) || 
				StringUtils.isBlank(endereco.getNumero()) || 
				StringUtils.isBlank(endereco.getRua())) {

			throw new InvalidAddressInputException();
		}
		
	}

}
