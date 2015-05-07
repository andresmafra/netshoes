package com.netshoes.cepservice.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.netshoes.cepservice.exception.InvalidCepException;
import com.netshoes.cepservice.model.Cep;

/**
 * Utilitary class for simple validation
 * 
 * @author andre.s.mafra
 * 
 */
@Component
public class ValidationUtil {

	/**
	 * Avoid instantiation
	 */
	private ValidationUtil() {
	}

	/**
	 * Simple validation the cep input
	 * 
	 * @param Cep
	 *            obj
	 * @throws InvalidCepException
	 */
	public static final void validateCEP(final Cep cep) throws InvalidCepException {

		if (cep == null) {
			throw new InvalidCepException("invalid cep");
		} else if (!StringUtils.isNumeric(cep.getId()) || cep.getId().length() != 8) {
			throw new InvalidCepException("cep " + cep.getId() + " is invalid");
		}

	}

}
