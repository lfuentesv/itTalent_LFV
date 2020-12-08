package com.lfuentes.glogic.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioApi {

	@PostMapping("")
	public ResponseEntity<String> registro(@RequestBody String usuario){
		
		return ResponseEntity.ok("registro");
	}
}
