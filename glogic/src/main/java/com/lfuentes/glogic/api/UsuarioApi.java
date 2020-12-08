package com.lfuentes.glogic.api;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lfuentes.glogic.dto.RegistroRequest;
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
	public ResponseEntity<RegistroResponse> registro(@Valid @RequestBody RegistroRequest usuarioRequest){
		logger.info("registro[INI] Usuario.name: "+ usuarioRequest.getName());
		
		Usuario usuario = mapper.map(usuarioRequest, Usuario.class);
		logger.debug("registro[001] despues de mapear el request");

		Usuario usuarioRespuesta = servicio.registrar(usuario);
		
		logger.debug("registro[002] antes de mapear la respuesta");
		RegistroResponse respuesta = mapper.map(usuarioRespuesta, RegistroResponse.class);
		
		logger.info("registro[FIN] respuesta.Id: "+ respuesta.getId());
		return new ResponseEntity <>(respuesta,HttpStatus.CREATED );
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Usuario>> selectUsuarioId(@PathVariable(value = "id") String id){
		logger.info("selectUsuarioId[INI] id: "+ id);
		
		Optional<Usuario> usuario = servicio.buscar(id);
		
		logger.info("selectUsuarioId[FIN] usuario.id: "+ usuario.get().getId());
		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Usuario>> selectUsuarios(){
		logger.info("selectUsuarioId[INI]");
		
		List<Usuario> usuarios = servicio.buscarOrdenadosPorCreacion();
		
		logger.info("selectUsuarioId[FIN] usuarios: "+ usuarios.size());
		return ResponseEntity.ok(usuarios);
	}
}
