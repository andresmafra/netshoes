package com.netshoes.cepservice.test;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.netshoes.cepservice.controller.CepController;
import com.netshoes.cepservice.exception.InvalidCepException;
import com.netshoes.cepservice.model.Cep;
import com.netshoes.cepservice.service.CepService;
import com.netshoes.cepservice.util.ValidationUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:**/WEB-INF/mvc-dispatcher-servlet.xml" })
public class CepControllerTest {

	private MockMvc mockMvc;

	@Mock
	private CepService cepService;

	@Mock
	private ValidationUtil validationUtil;

	@InjectMocks
	private CepController cepController;

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(cepController).dispatchOptions(true).build();
	}

	/**
	 * Tests the system behavior with a given valid cep
	 * 
	 * @throws Exception
	 */
	@Test
	public void getCepByIdTest() throws Exception {

		Cep cepIn = new Cep();
		cepIn.setId("06753160");

		Cep cepOut = new Cep();
		cepOut.setId("06753160");
		cepOut.setEstado("SP");

		when(cepController.getCep(cepIn)).thenReturn(cepOut);
		
		String body = "{ \"id\": \"06753160\" }";

		mockMvc.perform(post("/").contentType(MediaType.APPLICATION_JSON).content(body)).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", is("06753160"))).andExpect(jsonPath("$.estado", is("SP")));
	}

	/**
	 * Tests the system behavior with a given invalid cep
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void invalidCepTest() throws Exception {

		Cep cepIn = new Cep();
		cepIn.setId("abc123");

		when(cepController.getCep(cepIn)).thenThrow(InvalidCepException.class);

		String body = "{ \"id\": \"abc123\" }";

		mockMvc.perform(post("/").contentType(MediaType.APPLICATION_JSON).content(body)).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.statusMessage", is("CEP invalido")));
	}

	/**
	 * Tests the system behavior while a valid cep not found, including zeros at
	 * the end
	 * 
	 * @throws Exception
	 */
	@Test
	public void cepFoundWithZerosTest() throws Exception {

		Cep cepIn = new Cep();
		cepIn.setId("10000001");

		Cep cepOut = new Cep();
		cepOut.setId("10000000");
		cepOut.setBairro("Zeros");

		when(cepController.getCep(cepIn)).thenReturn(cepOut);

		String body = "{ \"id\": \"10000001\" }";

		mockMvc.perform(post("/").contentType(MediaType.APPLICATION_JSON).content(body)).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", is("10000000"))).andExpect(jsonPath("$.bairro", is("Zeros")));
	}

	/**
	 * Tests the system behavior with a cep not found
	 * 
	 * @throws Exception
	 */
	@Test
	public void cepNotFoundTest() throws Exception {

		Cep cepIn = new Cep();
		cepIn.setId("11111111");

		Cep cepOut = new Cep();

		when(cepController.getCep(cepIn)).thenReturn(cepOut);

		String body = "{ \"id\": \"11111111\" }";

		mockMvc.perform(post("/").contentType(MediaType.APPLICATION_JSON).content(body)).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", IsNull.nullValue()));
	}

}
