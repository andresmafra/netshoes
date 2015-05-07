package com.netshoes.cepservice.mock;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.netshoes.cepservice.model.Cep;

/**
 * Cep mock generator class
 * 
 * @author andre.s.mafra
 * 
 */
@Component
public class CepDataMock {

	/**
	 * Cep available list
	 */
	private List<Cep> availableCepList;

	/**
	 * Cep generator
	 */
	@PostConstruct
	public void generatorInit() {

		availableCepList = new ArrayList<Cep>(1);

		Cep cep1 = new Cep();
		cep1.setId("06753160");
		cep1.setBairro("Jardim Abc");
		cep1.setCidade("Guarulhos");
		cep1.setEstado("SP");
		cep1.setRua("Rua Fulano de Tal");

		availableCepList.add(cep1);

		Cep cep2 = new Cep();
		cep2.setId("06753161");
		cep2.setBairro("Jardim Aparecida");
		cep2.setCidade("Guarulhos");
		cep2.setEstado("SP");
		cep2.setRua("Rua Ciclano de Tal");

		availableCepList.add(cep2);

		Cep cep3 = new Cep();
		cep3.setId("06753162");
		cep3.setBairro("Jardim Da Paz");
		cep3.setCidade("Guarulhos");
		cep3.setEstado("SP");
		cep3.setRua("Rua do Abc");

		availableCepList.add(cep3);

		Cep cep4 = new Cep();
		cep4.setId("06753163");
		cep4.setBairro("Jardim Aeiou");
		cep4.setCidade("Guarulhos");
		cep4.setEstado("SP");
		cep4.setRua("Rua Aeiou");

		Cep cep5 = new Cep();
		cep5.setId("06753100");
		cep5.setBairro("Jardim dos Zeros");
		cep5.setCidade("Guarulhos");
		cep5.setEstado("SP");
		cep5.setRua("Rua Zero");

		Cep cep6 = new Cep();
		cep6.setId("10000000");
		cep6.setBairro("Jardim da Web");
		cep6.setCidade("Guarulhos");
		cep6.setEstado("SP");
		cep6.setRua("Rua Netshoes");

		Cep cep7 = new Cep();
		cep7.setId("23456000");
		cep7.setBairro("Jardim da Net");
		cep7.setCidade("Guarulhos");
		cep7.setEstado("SP");
		cep7.setRua("Rua Shoes");

		availableCepList.add(cep7);
	}

	/**
	 * @return the availableCepList
	 */
	public List<Cep> getAvailableCepList() {
		return availableCepList;
	}

	/**
	 * @param availableCepList
	 *            the availableCepList to set
	 */
	public void setAvailableCepList(List<Cep> availableCepList) {
		this.availableCepList = availableCepList;
	}

}
