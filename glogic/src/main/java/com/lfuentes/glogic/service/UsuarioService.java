package com.lfuentes.glogic.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lfuentes.glogic.dao.UsuarioRepositorio;
import com.lfuentes.glogic.dto.Usuario;
import com.lfuentes.glogic.utils.TokenUtils;
import com.lfuentes.glogic.validacion.EmailDuplicadoException;
import com.lfuentes.glogic.validacion.UsuarioNoEncontradoException;

@Service
public class UsuarioService {

		@Autowired
		private UsuarioRepositorio repo;
		
		private Logger logger = LoggerFactory.getLogger(UsuarioService.class);
		
		public Usuario registrar(Usuario usuario) {
			logger.info("registra[INI] usuario.email: "+usuario.getEmail());
			
			if (repo.existsUsuarioByEmail(usuario.getEmail())) {
				logger.info("registra[FIN] email ya registrado en BD: "+usuario.getEmail());
				throw new EmailDuplicadoException(usuario.getEmail());
			}
			
			usuario.setToken(TokenUtils.getJWTToken(usuario.getName()));
			
			Usuario usuarioSaved = repo.saveAndFlush(usuario);
			
			logger.info("registra[FIN] usuarioSaved.Id: "+usuarioSaved.getId());
			return usuarioSaved;
		}

		public Optional<Usuario> buscar(String id) {
			return Optional.ofNullable(repo.findById(id).orElseThrow(() -> new UsuarioNoEncontradoException(id)));
		}

		public List<Usuario> buscarOrdenadosPorCreacion() {
			logger.info("buscarOrdenadosPorCreacion[INI]");
			
			/**
			 * De forma más directa puede ser:
			 * repo.findAll(Sort.by(Sort.Direction.DESC, "created") );  
			 * */
			  
			List<Usuario> usuarios = repo.findAll();
			logger.debug("buscarOrdenadosPorCreacion[001] usuarios: "+usuarios.size());
			usuarios.sort(Comparator.comparing(Usuario::getCreated).reversed());
			
			logger.info("buscarOrdenadosPorCreacion[FIN] lista ordenada: "+usuarios.size());
			return usuarios;
		}
}
