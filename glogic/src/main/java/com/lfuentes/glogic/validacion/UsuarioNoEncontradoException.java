package com.lfuentes.glogic.validacion;

public class UsuarioNoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = -4193386220419774337L;

	public UsuarioNoEncontradoException(String id) {
        super("El usuario id ("+id+") no fue encontrado");
    }

}
