package com.curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.modelo.entidad.Producto;
import com.curso.modelo.repositorio.RepositorioProductos;

@Service
@Transactional
public class ProjectorProductos {

	@Autowired private RepositorioProductos repoProductos;
	
	public void insertar(Producto producto) {
		System.out.println("Insertando el producto:"+producto);
		repoProductos.save(producto);
	}

	public void modificar(Producto producto) {
		System.out.println("Modificando el producto:"+producto);
		repoProductos.save(producto);
	}

	public void borrar(String referencia) {
		System.out.println("Borrando el producto:"+referencia);
		repoProductos.deleteById(referencia);
	}

}
