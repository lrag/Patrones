package com.curso.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.curso.modelo.negocio.TrazaElJamonService;

@RestController
public class ControladorTrazaElCerdo {

	@Autowired private TrazaElJamonService trazaElJamonService;
	
	//@GetMapping("/cerdo/{idCerdo}")
	//public ResponseEntity<T>
	
	
}
