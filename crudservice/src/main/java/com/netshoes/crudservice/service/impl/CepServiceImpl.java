package com.netshoes.crudservice.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netshoes.crudservice.model.CustomCep;
import com.netshoes.crudservice.service.CepService;

/**
 * Implementation of CepService interface
 * 
 * @author andre.s.mafra
 * 
 */
@Service
public class CepServiceImpl implements CepService {

	/**
	 * cepservice API uri
	 */
	@Value("${cepservice_host}")
	private String uri;

	/**
	 * @see CepService
	 */
	public CustomCep validateCep(String id) {

		final String body = "{ \"id\": \"" + id + "\" }";

		CustomCep cep = null;

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CustomCep> result = restTemplate
				.exchange(uri, HttpMethod.POST, new HttpEntity<String>(body, headers), CustomCep.class);

		if(result.getBody() != null) {
			cep = ((CustomCep) result.getBody());
		}
		
		return cep;
	}

}
