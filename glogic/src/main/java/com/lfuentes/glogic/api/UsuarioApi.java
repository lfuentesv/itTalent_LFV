package com.lfuentes.glogic.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lfuentes.glogic.dto.Usuario;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioApi {

	Logger logger = LoggerFactory.getLogger(UsuarioApi.class);
	
	@PostMapping("")
	public ResponseEntity<String> registro(@RequestBody Usuario usuario){
		logger.info("registro[INI] Usuario.name: "+ usuario.getName());
		
		
		logger.info("registro[FIN]");
		return ResponseEntity.ok("registro");
	}
}
