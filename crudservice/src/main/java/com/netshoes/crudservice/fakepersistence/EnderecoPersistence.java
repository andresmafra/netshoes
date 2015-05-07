package com.netshoes.crudservice.fakepersistence;

import java.util.List;

import com.netshoes.crudservice.exception.GenericAPIException;
import com.netshoes.crudservice.model.Endereco;

/**
 * Endereco persistence sign methods
 * 
 * @author andre.s.mafra
 * 
 */
public interface EnderecoPersistence {

	/**
	 * Insert a Endereco model into db
	 * 
	 * @param endereco
	 * @return
	 */
	String insert(Endereco endereco);

	/**
	 * Update a Endereco model into db
	 * 
	 * @param endereco
	 * @throws GenericAPIException
	 */
	String update(Endereco endereco) throws GenericAPIException;

	/**
	 * Get a Endereco model from db
	 * 
	 * @param id
	 * @return
	 */
	Endereco get(String id);

	/**
	 * Delete a Endereco model from db
	 * 
	 * @param id
	 */
	boolean delete(String id);

	/**
	 * List all address (Testing purposes)
	 * 
	 * @return
	 */
	List<Endereco> listAll();
}
