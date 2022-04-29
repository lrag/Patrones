package com.curso.endpoint;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.endpoint.dto.ProductoDTO;
import com.curso.modelo.entidad.Producto;
import com.curso.modelo.negocio.GestorProductos;
import com.curso.modelo.repositorio.RepositorioProductos;

@RestController
public class ProductosEndpoint {
	
	@Autowired
	private GestorProductos gestorProductos;

	@PostMapping("/productos")
	public ResponseEntity<ProductoDTO> altaProducto(@RequestBody ProductoDTO productoDTO){
		Producto producto = gestorProductos.insertar(productoDTO.asProducto());
		return new ResponseEntity<ProductoDTO>(new ProductoDTO(producto), HttpStatus.CREATED);
	}
	
	public ResponseEntity<ProductoDTO> modificarProducto(@RequestBody ProductoDTO productoDTO, @PathVariable("referencia") String referencia){
		productoDTO.setReferencia(referencia);
		Producto producto =	gestorProductos.modificar(productoDTO.asProducto());				
		return new ResponseEntity<>(new ProductoDTO(producto), HttpStatus.OK);
	}

	@DeleteMapping("/productos/{referencia}")
	public ResponseEntity<Void> eliminarProducto(@PathVariable("referencia") String referencia) {
		gestorProductos.borrar(referencia);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//ESTO ES PARA PRUEBAS. AQUI NO PINTA NADA////////////
	@Autowired private RepositorioProductos repoProductos;
	@GetMapping("/productos")
	public List<ProductoDTO> listar(){
		return repoProductos
			.findAll()
			.stream()
			.map(p -> new ProductoDTO(p))
			.collect(Collectors.toList());
	}
	
}
