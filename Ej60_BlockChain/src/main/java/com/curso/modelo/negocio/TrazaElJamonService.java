package com.curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.tuples.generated.Tuple5;

import com.curso.endpoint.dto.CerdoDTO;
import com.curso.endpoint.dto.DatosSacrificio;
import com.curso.endpoint.dto.DatosVacunacion;
import com.curso.modelo.contrato.proxy.TrazaElJamon;

@Service
public class TrazaElJamonService {

	@Autowired
	private TrazaElJamon trazaElJamon;

	public CerdoDTO buscarCerdo(String idCerdo) throws Exception {
		Tuple5<String, String, String, String, String> respuesta = trazaElJamon
			.buscarCerdo(idCerdo)
			.send();
		CerdoDTO cerdito = new CerdoDTO(respuesta);
		System.out.println(respuesta);
		System.out.println(cerdito);
		return cerdito;
	}

	public void vacunarCerdo(DatosVacunacion datosVacunacion) throws Exception {
		System.out.println(datosVacunacion);
		Object r = trazaElJamon
			.vacunarCerdo(datosVacunacion.getIdCerdo(), datosVacunacion.getIdVeterinario())
			.send();
		System.out.println("Respuesta:"+r);
	}

	public void sacrificarCerdo(DatosSacrificio datosSacrificio) throws Exception {
		System.out.println(datosSacrificio);
		Object r = trazaElJamon
				.sacrificarCerdo(datosSacrificio.getIdCerdo(), datosSacrificio.getIdMatadero())
				.send();
		System.out.println("Respuesta:"+r);
	}

	public void crearCerdo(CerdoDTO cerdo) throws Exception {
		System.out.println(cerdo);
		Object r = trazaElJamon
				.crearCerdo(cerdo.getId(), cerdo.getIdGranjero(), cerdo.getRaza())
				.send();
		System.out.println("Respuesta:"+r);		
	}
	
}