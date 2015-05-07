package com.netshoes.crudservice.service;

import java.util.List;

import com.netshoes.crudservice.exception.GenericAPIException;
import com.netshoes.crudservice.model.Endereco;

/**
 * Endereco service layer
 * 
 * @author andre.s.mafra
 * 
 */
public interface EnderecoService {

	/**
	 * Insert a Endereco model into db
	 * 
	 * @param endereco
	 * @return
	 */
	String insertAddress(Endereco endereco);

	/**
	 * Update a Endereco model into db
	 * 
	 * @param endereco
	 * @throws GenericAPIException
	 */
	String updateAddress(Endereco endereco) throws GenericAPIException;

	/**
	 * Get a Endereco model from db
	 * 
	 * @param id
	 * @return
	 */
	Endereco getAddress(String id);

	/**
	 * Delete a Endereco model from db
	 * 
	 * @param id
	 */
	boolean deleteAddress(String id);

	/**
	 * Get all address for testing purposes only
	 * 
	 * @return
	 */
	List<Endereco> getAll();
}
