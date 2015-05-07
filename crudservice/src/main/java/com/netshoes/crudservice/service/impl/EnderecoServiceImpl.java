package com.netshoes.crudservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netshoes.crudservice.exception.GenericAPIException;
import com.netshoes.crudservice.fakepersistence.EnderecoPersistence;
import com.netshoes.crudservice.model.Endereco;
import com.netshoes.crudservice.service.EnderecoService;

/**
 * Endereco service layer impl
 * 
 * @author andre.s.mafra
 * 
 */
@Service
public class EnderecoServiceImpl implements EnderecoService {

	/**
	 * Persistence API
	 */
	@Autowired
	private EnderecoPersistence enderecoPersistence;

	/**
	 * @see EnderecoService
	 */
	public String insertAddress(Endereco endereco) {
		return enderecoPersistence.insert(endereco);
	}

	/**
	 * @throws GenericAPIException
	 * @see EnderecoService
	 */
	public String updateAddress(Endereco endereco) throws GenericAPIException {
		return enderecoPersistence.update(endereco);
	}

	/**
	 * @see EnderecoService
	 */
	public Endereco getAddress(String id) {
		return enderecoPersistence.get(id);
	}

	/**
	 * @see EnderecoService
	 */
	public boolean deleteAddress(String id) {
		return enderecoPersistence.delete(id);
	}

	/**
	 * @see EnderecoService
	 */
	public List<Endereco> getAll() {
		return enderecoPersistence.listAll();
	}

}
