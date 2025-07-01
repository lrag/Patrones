package com.curso.endpoint;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.curso.endpoint.dto.ProductoDTO;
import com.curso.modelo.repositorio.RepositorioProductos;

@RestController
public class ProductosEndpoint {

	@Autowired
	private RepositorioProductos repoProductos;

	@GetMapping("/productos")
	public List<ProductoDTO> listar() {
		return repoProductos.findAll().stream().map(p -> new ProductoDTO(p)).collect(Collectors.toList());
	}

	@GetMapping("/productos/{referencia}")
	public ResponseEntity<ProductoDTO> buscarProducto(@PathVariable("referencia") String idProducto) {
		return repoProductos.findById(idProducto)
				.map(p -> new ResponseEntity<ProductoDTO>(new ProductoDTO(p), HttpStatus.OK))
				.orElse(new ResponseEntity<ProductoDTO>(HttpStatus.NOT_FOUND));
	}

}
