package com.curso.endpoint;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.curso.endpoint.dto.Mensaje;

@ControllerAdvice
public class ControladorExcepciones {

	public ControladorExcepciones() {
		super();
	}

	@ExceptionHandler(Throwable.class)
	@ResponseBody
	public ResponseEntity<?> handleException(Exception e) {
		return new ResponseEntity<Mensaje>(new Mensaje("500","Nos hemos caido con todo el equipo"), HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	
}
