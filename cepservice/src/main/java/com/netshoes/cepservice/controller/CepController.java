package com.netshoes.cepservice.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netshoes.cepservice.exception.CepNotFoundException;
import com.netshoes.cepservice.exception.InvalidCepException;
import com.netshoes.cepservice.model.BadStatus;
import com.netshoes.cepservice.model.Cep;
import com.netshoes.cepservice.service.CepService;
import com.netshoes.cepservice.util.ValidationUtil;

/**
 * Main controller responsible for handle the CEP API requests
 * 
 * @author andre.s.mafra
 * 
 */
@Controller
@RequestMapping("/")
public class CepController {

	@Autowired
	private CepService cepService;

	@Autowired
	private ValidationUtil validationUtil;

	/**
	 * Maximum retry quantity
	 */
	private static final int MAX_RETRY_QUANTITY = 8;

	/**
	 * Zero var
	 */
	private static final String ZERO = "0";

	/**
	 * Method responsible for getting the cep based on a received id
	 * 
	 * @param id
	 *            CEP id
	 * @return CEP data
	 * @throws InvalidCepException
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	Cep getCep(@RequestBody Cep cepIn) throws InvalidCepException {

		// Validate the input cep
		validationUtil.validateCEP(cepIn);

		// Ge the cep in db and return
		return getCepWithRetry(cepIn.getId(), 1);
	}

	/**
	 * @param cepIn
	 * @return
	 * @throws CepNotFoundException
	 */
	private Cep getCepWithRetry(String id, int tentative) {

		Cep cep = null;

		try {
			cep = getLocalCep(id);
		} catch (CepNotFoundException e) {

			if (tentative <= MAX_RETRY_QUANTITY) {
				id = StringUtils.reverse(StringUtils.reverse(id).substring(tentative)) + fillWithZeros(tentative);
				cep = getCepWithRetry(id, ++tentative);
			}
		}

		return cep;
	}

	/**
	 * Return zeros for fill the CEP
	 * 
	 * @param quantity
	 *            the quantity of zeros
	 * @return
	 */
	private String fillWithZeros(int quantity) {

		String zero = "";
		int i = 0;

		while (i < quantity) {
			zero = zero + ZERO;
			i++;
		}

		return zero;
	}

	/**
	 * Local method for calling the cepService API
	 * 
	 * @param id
	 *            CEP id
	 * @return CEP data
	 * @throws CepNotFoundException
	 *             Thrown when the cep is not found on DB
	 */
	private Cep getLocalCep(String id) throws CepNotFoundException {
		return cepService.getCepById(id);
	}

	// @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason =
	// "CEP invalido")
	@ExceptionHandler(InvalidCepException.class)
	public @ResponseBody
	BadStatus exceptionHandler() {
		return new BadStatus("CEP invalido");
	}

}
