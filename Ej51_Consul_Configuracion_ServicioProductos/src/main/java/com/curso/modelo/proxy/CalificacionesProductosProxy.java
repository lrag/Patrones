package com.curso.modelo.proxy;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.curso.modelo.entidad.CalificacionProducto;

@Component
public class CalificacionesProductosProxy {

	@Autowired
	private RestTemplate restTemplate;
	
	public List<CalificacionProducto> buscarCalificacionesProducto(String codigoProducto){		
		List<CalificacionProducto> calificaciones = null;		
		//return restTemplate.getForEntity("http://localhost:9000/clientes/"+login, Cliente.class);
		CalificacionProducto[] calificacionesArray = restTemplate
			.getForEntity(
				"http://ServicioCalificacionesProductos/calificaciones_productos?codigoProducto="+codigoProducto
				,CalificacionProducto[].class)
			.getBody();
		return calificaciones = Arrays.asList(calificacionesArray);
	}
	
}
