package com.netshoes.crudservice.test;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.netshoes.crudservice.controller.CrudController;
import com.netshoes.crudservice.model.CustomCep;
import com.netshoes.crudservice.model.Endereco;
import com.netshoes.crudservice.service.CepService;
import com.netshoes.crudservice.service.EnderecoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:**/WEB-INF/mvc-dispatcher-servlet.xml" })
public class CrudControllerTest {

	private MockMvc mockMvc;

	@Mock
	private EnderecoService enderecoService;

	@Mock
	private CepService cepService;

	@InjectMocks
	private CrudController crudController;

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(crudController).dispatchOptions(true).build();
	}

	/**
	 * Create address test
	 * 
	 * @throws Exception
	 */
	@Test
	public void createAddressTest() throws Exception {

		final String cep = "06753160";
		final String id = "12345";

		Endereco enderecoIn = new Endereco();
		enderecoIn.setCep(cep);
		enderecoIn.setCidade("Abc");
		enderecoIn.setEstado("SP");
		enderecoIn.setNumero("123");
		enderecoIn.setRua("rua abc");

		CustomCep customCep = new CustomCep();
		customCep.setId(cep);

		when(cepService.validateCep(cep)).thenReturn(customCep);
		when(enderecoService.insertAddress(enderecoIn)).thenReturn(id);
		when(crudController.createAddress(enderecoIn)).thenReturn(Mockito.any(Endereco.class));

		String body = "{\"rua\":\"Rua 2\",\"numero\":\"02\",\"cep\":\"06753160\",\"cidade\":\"Abc\",\"estado\":\"RJ\"}";

		mockMvc.perform(post("/").contentType(MediaType.APPLICATION_JSON).content(body)).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.cep", is(cep)));
	}

	/**
	 * Update address test
	 * 
	 * @throws Exception
	 */
	@Test
	public void updateAddressTest() throws Exception {

		final String cep = "06753160";
		final String id = "12345";

		Endereco enderecoIn = new Endereco();
		enderecoIn.setCep(cep);
		enderecoIn.setCidade("Abc");
		enderecoIn.setEstado("SP");
		enderecoIn.setNumero("123");
		enderecoIn.setRua("rua abc");

		Endereco enderecoOut = new Endereco();
		enderecoOut.setId(id);
		enderecoOut.setCep(cep);
		enderecoOut.setCidade("Abc");
		enderecoOut.setEstado("SP");
		enderecoOut.setNumero("1234");
		enderecoOut.setRua("rua abc");

		CustomCep customCep = new CustomCep();
		customCep.setId(cep);

		when(cepService.validateCep(cep)).thenReturn(customCep);
		when(enderecoService.updateAddress(enderecoIn)).thenReturn(id);

		String body = "{\"rua\":\"rua abc\",\"numero\":\"1234\",\"cep\":\"06753160\",\"cidade\":\"Abc\",\"estado\":\"SP\"}";

		mockMvc.perform(put("/").contentType(MediaType.APPLICATION_JSON).content(body)).andDo(MockMvcResultHandlers.print())
				.andExpect(status().is(HttpStatus.NO_CONTENT.value()));
	}

	/**
	 * Delete address test
	 * 
	 * @throws Exception
	 */
	@Test
	public void deleteAddressTest() throws Exception {

		final String id = "12345";

		when(enderecoService.deleteAddress(id)).thenReturn(true);
		
		mockMvc.perform(delete("/" + id).contentType(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk());
	}

	/**
	 * Get address test
	 * 
	 * @throws Exception
	 */
	@Test
	public void getAddressTest() throws Exception {

		final String cep = "06753160";
		final String id = "12345";

		Endereco enderecoOut = new Endereco();
		enderecoOut.setCep(cep);
		enderecoOut.setCidade("Abc");
		enderecoOut.setEstado("SP");
		enderecoOut.setNumero("123");
		enderecoOut.setRua("rua abc");

		when(enderecoService.getAddress(id)).thenReturn(enderecoOut);
		when(crudController.getAddress(id)).thenReturn(enderecoOut);

		mockMvc.perform(get("/" + id).contentType(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.cep", is(cep)));
	}

}
