package com.lfuentes.glogic.validacion;

public class EmailDuplicadoException extends RuntimeException {

	private static final long serialVersionUID = 8211717600439964294L;

	public EmailDuplicadoException(String email) {
        super("El correo informado ya esta registrado ("+email+")");
    }

}
