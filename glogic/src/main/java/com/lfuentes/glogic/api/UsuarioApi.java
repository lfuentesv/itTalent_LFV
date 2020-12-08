package com.lfuentes.glogic.api;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lfuentes.glogic.dto.RegistroResponse;
import com.lfuentes.glogic.dto.Usuario;
import com.lfuentes.glogic.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioApi {

	private Logger logger = LoggerFactory.getLogger(UsuarioApi.class);
	
	@Autowired
	private UsuarioService servicio;
	
	@Autowired 
	private Mapper mapper;
	
	@PostMapping("")
	public ResponseEntity<RegistroResponse> registro(@RequestBody Usuario usuario){
		logger.info("registro[INI] Usuario.name: "+ usuario.getName());
		
		Usuario usuarioRegistrado = servicio.registrar(usuario);
		
		logger.info("registro[001] antes de mapear la respuesta");
		RegistroResponse respuesta = mapper.map(usuarioRegistrado, RegistroResponse.class);
		
		logger.info("registro[FIN] respuesta.Id: "+ respuesta.getId());
		return ResponseEntity.ok(respuesta);
	}
}
