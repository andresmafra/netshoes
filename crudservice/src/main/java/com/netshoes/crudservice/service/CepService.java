package com.netshoes.crudservice.service;

import com.netshoes.crudservice.model.CustomCep;

/**
 * Interface that sign the Cep API call methods
 * 
 * @author andre.s.mafra
 * 
 */
public interface CepService {

	/**
	 * Validates a CEP id making a call to cepservice API
	 * 
	 * @param id
	 * @return
	 */
	CustomCep validateCep(final String id);
}
