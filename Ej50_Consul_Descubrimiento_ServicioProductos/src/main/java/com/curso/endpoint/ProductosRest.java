package com.curso.endpoint;

import java.util.List;
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
import com.curso.modelo.negocio.GestorProductos;
import com.curso.modelo.persistencia.ProductoRepositorio;

@RestController
public class ProductosRest {

	@Autowired private GestorProductos gestorProductos;
	@Autowired private ProductoRepositorio productoRepo;
	
	//GET    /productos/{codigo} 				  - El producto sin calificaciones
	//GET    /productos/{codigo}/calificaciones   - Las calificaciones de un producto
	//GET    /productos					          - Todos los productos
	//POST   /productos						      - Insertar un producto
	//PUT    /productos/{codigo}   			      - Modificar un producto
	//DELETE /productos/{codigo}			      - Insertar un producto
	
	@GetMapping(path="/productos/{codigo}")
	public ResponseEntity<ProductoDTO> buscar(@PathVariable("codigo") String codigo){
		System.out.println("Buscando por codigo:"+codigo);
		return 
			productoRepo
				.findByCodigo(codigo)
				.map(p -> {
					System.out.println("Encontrado:"+p);
					
					return new ResponseEntity<ProductoDTO>(new ProductoDTO(p), HttpStatus.OK);
				})
				.orElse(new ResponseEntity<ProductoDTO>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping(path="/productos/{codigo}/calificaciones")
	public ResponseEntity<ProductoDTO> buscarConCalificaciones(@PathVariable("codigo") String codigo){
		return 
			gestorProductos
				.buscarProductoYCalificaciones(codigo)
				.map(p -> new ResponseEntity<ProductoDTO>(new ProductoDTO(p), HttpStatus.OK))
				.orElse(new ResponseEntity<ProductoDTO>(HttpStatus.NOT_FOUND));
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
		Producto productoInsertado = gestorProductos.insertar(productoDto.asProducto());
		return new ResponseEntity<Producto>(productoInsertado, HttpStatus.CREATED);
	}
	
}
