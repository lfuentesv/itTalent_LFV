package com.lfuentes.glogic.validacion;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.lfuentes.glogic.dto.Error;
import com.lfuentes.glogic.dto.ErrorResponse;


@ControllerAdvice
public class RegistroControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	ErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		ErrorResponse respuestaError = new ErrorResponse();
		for (FieldError campo : e.getBindingResult().getFieldErrors()) {
			respuestaError.getErrores().add(new Error(campo.getDefaultMessage()));
		}
		return respuestaError;
	}
	
	@ExceptionHandler(EmailDuplicadoException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	ErrorResponse onEmailDuplicadoException(EmailDuplicadoException e) {
		ErrorResponse error = new ErrorResponse();
		error.getErrores().add(new Error(e.getMessage()));
	  return error;
	}
}
