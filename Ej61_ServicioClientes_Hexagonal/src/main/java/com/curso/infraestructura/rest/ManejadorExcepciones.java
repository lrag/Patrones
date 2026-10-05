package com.curso.infraestructura.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.curso.dominio.ClienteYaExisteException;

@RestControllerAdvice
public class ManejadorExcepciones {

	@ExceptionHandler(ClienteYaExisteException.class)
	public ResponseEntity<String> clienteYaExiste(ClienteYaExisteException e) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	}

}
