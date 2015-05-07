package com.netshoes.cepservice.service;

import com.netshoes.cepservice.exception.CepNotFoundException;
import com.netshoes.cepservice.model.Cep;

/**
 * Interface for signing the methods relative to Cep service layer
 * 
 * @author andre.s.mafra
 * 
 */
public interface CepService {

	/**
	 * Method that get a cep in database by a given Id
	 * 
	 * @param id
	 *            cep Id
	 * @return Cep object
	 * @throws CepServiceException
	 *             Some error that occurr in database
	 */
	Cep getCepById(final String id) throws CepNotFoundException;
}
