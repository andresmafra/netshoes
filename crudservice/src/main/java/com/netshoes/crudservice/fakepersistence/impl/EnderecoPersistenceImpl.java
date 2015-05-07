package com.netshoes.crudservice.fakepersistence.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.netshoes.crudservice.exception.GenericAPIException;
import com.netshoes.crudservice.fakepersistence.EnderecoPersistence;
import com.netshoes.crudservice.model.Endereco;

/**
 * Endereco mock generator class
 * 
 * @author andre.s.mafra
 * 
 */
@Component
public class EnderecoPersistenceImpl implements EnderecoPersistence {

	/**
	 * Endereco persistence data
	 */
	private Set<Endereco> enderecoData;

	@PostConstruct
	public void init() {
		enderecoData = new HashSet<Endereco>();
	}

	/**
	 * @see EnderecoPersistence
	 */
	public String insert(Endereco endereco) {
		final String addressId = generateId();
		endereco.setId(addressId);
		enderecoData.add(endereco);
		return addressId;
	}

	/**
	 * @throws GenericAPIException
	 * @see EnderecoPersistence
	 */
	public String update(Endereco endereco) throws GenericAPIException {

		Endereco found = isInCollection(endereco.getId());

		if (found != null) {

			Endereco copy = null;

			try {

				copy = (Endereco) found.clone();

				if (StringUtils.isNotBlank(endereco.getBairro())) {
					copy.setBairro(endereco.getBairro());
				}

				if (StringUtils.isNotBlank(endereco.getComplemento())) {
					copy.setComplemento(endereco.getComplemento());
				}

				copy.setCep(endereco.getCep());
				copy.setCidade(endereco.getCidade());
				copy.setEstado(endereco.getEstado());
				copy.setNumero(endereco.getNumero());
				copy.setRua(endereco.getRua());

				enderecoData.remove(found);
				enderecoData.add(copy);

			} catch (CloneNotSupportedException e) {
				throw new GenericAPIException();
			}
			
			return endereco.getId();

		} else {
			return insert(endereco);
		}
	}

	/**
	 * @see EnderecoPersistence
	 */
	public Endereco get(String id) {
		return isInCollection(id);
	}

	/**
	 * @see EnderecoPersistence
	 */
	public boolean delete(String id) {
		Endereco toDelete = isInCollection(id);
		return toDelete != null ? enderecoData.remove(toDelete) : false;
	}

	/**
	 * Verify if the address is in collection
	 * 
	 * @param endereco
	 */
	private Endereco isInCollection(String id) {

		for (Endereco local : enderecoData) {
			if (local.getId().equalsIgnoreCase(id)) {
				return local;
			}
		}

		return null;
	}

	/**
	 * This method generate a random id
	 * 
	 * @return
	 */
	private static final String generateId() {
		return UUID.randomUUID().toString();
	}

	/**
	 * Testing purposes only
	 */
	public List<Endereco> listAll() {
		return new ArrayList<Endereco>(enderecoData);
	}

}
