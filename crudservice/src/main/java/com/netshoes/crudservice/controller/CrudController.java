package com.netshoes.crudservice.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.netshoes.crudservice.exception.CepValidationException;
import com.netshoes.crudservice.exception.GenericAPIException;
import com.netshoes.crudservice.exception.InvalidAddressInputException;
import com.netshoes.crudservice.exception.ResourceNotFoundException;
import com.netshoes.crudservice.model.BadStatus;
import com.netshoes.crudservice.model.CustomCep;
import com.netshoes.crudservice.model.Endereco;
import com.netshoes.crudservice.service.CepService;
import com.netshoes.crudservice.service.EnderecoService;
import com.netshoes.crudservice.util.ValidationUtil;

/**
 * Controller responsible for handle the CRUD API requests
 * 
 * @author andre.s.mafra
 * 
 */
@Controller
@RequestMapping("/")
public class CrudController {

	/**
	 * Endereco service
	 */
	@Autowired
	private EnderecoService enderecoService;

	/**
	 * Cep service
	 */
	@Autowired
	private CepService cepService;

	/**
	 * Create address endpoint API
	 * 
	 * @param endereco
	 * @throws InvalidAddressInputException
	 * @throws CepValidationException
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	Endereco createAddress(@RequestBody Endereco endereco) throws InvalidAddressInputException, CepValidationException {

		ValidationUtil.validateInput(endereco);
		this.validateCepAPI(endereco);

		final String id = enderecoService.insertAddress(endereco);
		endereco.setId(id);

		return endereco;
	}

	/**
	 * @param endereco
	 * @throws CepValidationException
	 */
	private void validateCepAPI(Endereco endereco) throws CepValidationException {

		CustomCep customCep = cepService.validateCep(endereco.getCep());

		if (customCep == null) {
			throw new CepValidationException();
		}

		if (StringUtils.isNotBlank(customCep.getStatusMessage())) {
			throw new CepValidationException(customCep.getStatusMessage());
		}
	}

	/**
	 * Update address endpoint API
	 * 
	 * @param endereco
	 * @throws InvalidAddressInputException
	 * @throws GenericAPIException
	 * @throws CepValidationException
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void updateAddress(@RequestBody Endereco endereco) throws InvalidAddressInputException, GenericAPIException,
			CepValidationException {

		ValidationUtil.validateInput(endereco);
		this.validateCepAPI(endereco);
		enderecoService.updateAddress(endereco);
	}

	/**
	 * Get address endpoint API
	 * 
	 * @param id
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Endereco getAddress(@PathVariable String id) throws ResourceNotFoundException {

		Endereco endereco = enderecoService.getAddress(id);

		if (endereco == null) {
			throw new ResourceNotFoundException();
		}

		return endereco;
	}

	/**
	 * List all address for testing purposes
	 * 
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<Endereco> getAll() throws ResourceNotFoundException {
		return enderecoService.getAll();
	}

	/**
	 * Delete address endpoint API
	 * 
	 * @param id
	 * @throws ResourceNotFoundException
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteAddress(@PathVariable String id) throws ResourceNotFoundException {

		if (!enderecoService.deleteAddress(id)) {
			throw new ResourceNotFoundException();
		}
	}

	/**
	 * Exception handler for Invalid input data
	 * 
	 * @return
	 */
	@ExceptionHandler(InvalidAddressInputException.class)
	public @ResponseBody
	BadStatus exceptionHandler() {
		return new BadStatus("Erro ao incluir/alterar o Endereco");
	}

	/**
	 * Exception handler for generic error
	 * 
	 * @return
	 */
	@ExceptionHandler(GenericAPIException.class)
	public @ResponseBody
	BadStatus exceptionGenericHandler() {
		return new BadStatus("Erro generico na API");
	}

	/**
	 * Exception handler for cep Validation
	 * 
	 * @return
	 */
	@ExceptionHandler(CepValidationException.class)
	public @ResponseBody
	BadStatus exceptionCepValidationHandler(CepValidationException ex) {
		return new BadStatus(ex.getMessage() != null ? ex.getMessage() : "Erro na validacao do cep");
	}

}
