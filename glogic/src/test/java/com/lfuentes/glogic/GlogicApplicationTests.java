package com.lfuentes.glogic;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lfuentes.glogic.api.UsuarioApi;

@SpringBootTest
class GlogicApplicationTests {

	@Autowired
	private UsuarioApi controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
