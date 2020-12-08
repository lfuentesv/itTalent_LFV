package com.lfuentes.glogic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lfuentes.glogic.dto.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {

}
