package com.curso.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.endpoint.dto.CerdoDTO;
import com.curso.endpoint.dto.DatosSacrificio;
import com.curso.endpoint.dto.DatosVacunacion;
import com.curso.modelo.negocio.TrazaElJamonService;

@RestController
public class TrazaElCerdoEndpoint {

	@Autowired private TrazaElJamonService trazaElJamonService;
	
	@GetMapping("/cerdos/{idCerdo}")
	public ResponseEntity<CerdoDTO> buscarCerdo(@PathVariable("idCerdo") String idCerdo) throws Exception{
		return new ResponseEntity<>(trazaElJamonService.buscarCerdo(idCerdo), HttpStatus.OK);
	}

	@PostMapping("/cerdos")
	public void buscarCerdo(@RequestBody CerdoDTO cerdo) throws Exception{
		trazaElJamonService.crearCerdo(cerdo);
	}

	@PostMapping("/vacunaciones")
	public void vacunarCerdo(@RequestBody DatosVacunacion datosVacunacion) throws Exception{
		trazaElJamonService.vacunarCerdo(datosVacunacion);
	}

	@PostMapping("/sacrificio")
	public void vacunarCerdo(@RequestBody DatosSacrificio datosSacrificio) throws Exception{
		trazaElJamonService.sacrificarCerdo(datosSacrificio);
	}
	
}
