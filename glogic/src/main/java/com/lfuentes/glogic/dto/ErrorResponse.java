package com.lfuentes.glogic.dto;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {
	
	private List<Error> errores = new ArrayList<>();

	public List<Error> getErrores() {
		return errores;
	}

	public void setErrores(List<Error> errores) {
		this.errores = errores;
	}
	
}
