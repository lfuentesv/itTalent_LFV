package com.lfuentes.glogic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lfuentes.glogic.dao.UsuarioRepositorio;
import com.lfuentes.glogic.dto.RegistroRequest;
import com.lfuentes.glogic.dto.Telefono;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioApiTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private UsuarioRepositorio repo;

	@Test
	void registarUsuario() throws Exception {
		RegistroRequest usuario = new RegistroRequest();
		usuario.setName("Juan Rodriguez");
		usuario.setEmail("juan@rodriguez.cl");
		usuario.setPassword("Hunter22");
		Telefono telefono = new Telefono();
		telefono.setNumber((long) 1234567);
		telefono.setCitycode(1);
		telefono.setContrycode(57);
		usuario.setPhones(Arrays.asList(telefono));

		mockMvc.perform(post("/usuario")
			   .contentType("application/json")
			   .content(objectMapper.writeValueAsString(usuario)))
			   .andExpect(status().isOk());

		assertThat(repo.existsUsuarioByEmail("juan@rodriguez.cl"));
	}
	
	@Test
	void emailDuplicado() throws Exception {
		RegistroRequest usuario = new RegistroRequest();
		usuario.setName("Pedro Rodriguez");
		usuario.setEmail("pedro@rodriguez.cl");
		usuario.setPassword("Hunter22");
		Telefono telefono = new Telefono();
		telefono.setNumber((long) 1234567);
		telefono.setCitycode(1);
		telefono.setContrycode(57);
		usuario.setPhones(Arrays.asList(telefono));

		mockMvc.perform(post("/usuario")
			   .contentType("application/json")
			   .content(objectMapper.writeValueAsString(usuario)))
			   .andExpect(status().isOk());
		
		mockMvc.perform(post("/usuario")
				   .contentType("application/json")
				   .content(objectMapper.writeValueAsString(usuario)))
				   .andExpect(jsonPath("$.errores[0].mensaje").value("El correo informado ya esta registrado (pedro@rodriguez.cl)"))
				   .andExpect(status().isBadRequest());

	}

}
