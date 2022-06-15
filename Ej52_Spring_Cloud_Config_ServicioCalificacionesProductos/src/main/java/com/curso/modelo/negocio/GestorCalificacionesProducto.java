package com.curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.modelo.entidad.CalificacionProducto;
import com.curso.modelo.persistencia.CalificacionProductoRepository;

@Service
public class GestorCalificacionesProducto {

	@Autowired
	private CalificacionProductoRepository calificacionProductoRepo;

	public CalificacionProducto insertar(CalificacionProducto producto) {
		//Lógica de negocio...
		//...
		return calificacionProductoRepo.save(producto);
	}
	
}
