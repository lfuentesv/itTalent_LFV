package com.lfuentes.glogic.validacion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.lfuentes.glogic.dto.Error;
import com.lfuentes.glogic.dto.ErrorResponse;


@ControllerAdvice
public class RegistroControllerAdvice {

	private Logger logger = LoggerFactory.getLogger(RegistroControllerAdvice.class);
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		logger.info("onMethodArgumentNotValidException[INI] e.errorCount: "+ e.getErrorCount());
		ErrorResponse respuestaError = new ErrorResponse();	
		e.getBindingResult().getFieldErrors().forEach((campo) -> respuestaError.getErrores().add(new Error(campo.getDefaultMessage())));
		logger.info("onMethodArgumentNotValidException[FIN] respuestaError: "+ respuestaError.getErrores().size());
		return respuestaError;
	}
	
	@ExceptionHandler(EmailDuplicadoException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse onEmailDuplicadoException(EmailDuplicadoException e) {
		logger.info("onEmailDuplicadoException[INI] e.message: "+ e.getMessage());
		ErrorResponse respuestaError = new ErrorResponse();
		respuestaError.getErrores().add(new Error(e.getMessage()));
		logger.info("onEmailDuplicadoException[FIN] respuestaError: "+ respuestaError.getErrores().size());
	  return respuestaError;
	}
}
