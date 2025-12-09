package com.curso.endpoint;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.endpoint.dto.ProductoDTO;
import com.curso.modelo.entidad.Producto;
import com.curso.modelo.negocio.ServicioProductos;
import com.curso.modelo.persistencia.ProductoRepositorio;

@RestController
public class ProductosRest {

	@Autowired private ServicioProductos servicioProductos;
	@Autowired private ProductoRepositorio productoRepo;
	
	//Solo el producto
	@GetMapping(path="/productos/{codigo}")
	public ResponseEntity<ProductoDTO> buscar(@PathVariable("codigo") String codigo){
		System.out.println("Buscando por codigo:"+codigo);
		
		/*
		Optional<Producto> opProducto = productoRepo.findByCodigo(codigo);
		if(opProducto.isPresent()) {
			Producto p = opProducto.get();
			ProductoDTO pDto = new ProductoDTO(p);
			return new ResponseEntity<ProductoDTO>(pDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<ProductoDTO>(HttpStatus.NOT_FOUND);
		}
		*/
		
		return 
			productoRepo
				.findByCodigo(codigo)
				.map(p -> {
					System.out.println("Encontrado:"+p);
					
					return new ResponseEntity<ProductoDTO>(new ProductoDTO(p), HttpStatus.OK);
				})
				.orElse(new ResponseEntity<ProductoDTO>(HttpStatus.NOT_FOUND));
	}
	
	//El producto y sus calificaciones
	@GetMapping(path="/productos/{codigo}/calificaciones")
	public ResponseEntity<ProductoDTO> buscarConCalificaciones(@PathVariable("codigo") String codigo){
		//Esto debería ser más bonito
		try {
			return servicioProductos
					.buscarProductoYCalificaciones(codigo)
					.map(p -> new ResponseEntity<ProductoDTO>(new ProductoDTO(p), HttpStatus.OK))
					.orElse(new ResponseEntity<ProductoDTO>(HttpStatus.NOT_FOUND));
		} catch (Exception e) {
			return new ResponseEntity<ProductoDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path="/productos")
	public List<ProductoDTO> listar(){
		return productoRepo
				.findAll()
				.stream()
				.map(p -> new ProductoDTO(p))
				.collect(Collectors.toList());
	}	
	
	@PostMapping(path="/productos")
	public ResponseEntity<Producto> insertar(@RequestBody() ProductoDTO productoDto){
		Producto productoInsertado = servicioProductos.insertar(productoDto.asProducto());
		return new ResponseEntity<Producto>(productoInsertado, HttpStatus.CREATED);
	}
	
}
