package com.lfuentes.glogic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lfuentes.glogic.dao.UsuarioRepositorio;
import com.lfuentes.glogic.dto.Usuario;
import com.lfuentes.glogic.utils.TokenUtils;
import com.lfuentes.glogic.validacion.EmailDuplicadoException;

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
}
