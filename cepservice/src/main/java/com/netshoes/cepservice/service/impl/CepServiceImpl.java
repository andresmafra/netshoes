package com.netshoes.cepservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netshoes.cepservice.exception.CepNotFoundException;
import com.netshoes.cepservice.mock.CepDataMock;
import com.netshoes.cepservice.model.Cep;
import com.netshoes.cepservice.service.CepService;

/**
 * Implementation of CEP API service layer
 * 
 * @author andre.s.mafra
 * 
 */
@Service
public class CepServiceImpl implements CepService {

	/**
	 * Cep dataMock
	 */
	@Autowired
	private CepDataMock cepDataMock;

	/**
	 * Implementation of Interface
	 * 
	 * @see CepService
	 */
	public Cep getCepById(String id) throws CepNotFoundException {

		final List<Cep> cepList = cepDataMock.getAvailableCepList();
		Cep cepFound = null;

		for (Cep cep : cepList) {
			if (cep.getId().equals(id)) {
				cepFound = cep;
				break;
			}
		}

		if (cepFound == null) {
			throw new CepNotFoundException("cep " + id + " not found");
		}

		return cepFound;
	}

}
