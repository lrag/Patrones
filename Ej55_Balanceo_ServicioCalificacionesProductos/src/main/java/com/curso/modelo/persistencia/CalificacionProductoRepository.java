package com.curso.modelo.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.curso.modelo.entidad.CalificacionProducto;

@Repository
public class CalificacionProductoRepository {

	private static List<CalificacionProducto> calificacionesProductos = new ArrayList<CalificacionProducto>();
	private static int contador = 0;
	
	public List<CalificacionProducto> findAll(){
		return calificacionesProductos;
	}
	
	public List<CalificacionProducto> findAllByCodigoProducto(String codigoProducto) {
		return calificacionesProductos
				.stream()
				.filter( cp -> cp.getCodigoProducto().equals(codigoProducto))
				.collect(Collectors.toList());
	}
	
	public CalificacionProducto save(CalificacionProducto calificacionProducto) {
		contador++;
		calificacionProducto.setId(contador);
		calificacionesProductos.add(calificacionProducto);
		return calificacionProducto;
	}		
	
}
