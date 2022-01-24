package com.curso.endpoint;

import java.util.UUID;
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
import com.curso.modelo.negocio.GestorProductos;
import com.curso.modelo.repositorio.RepositorioProductos;

import java.util.List;

@RestController
public class ProductosEndpoint {
	
	@Autowired
	private GestorProductos gestorProductos;

	@PostMapping("/productos")
	public ResponseEntity<Void> altaProducto(@RequestBody ProductoDTO productoDTO){
		//Lo mismo necesitamos algo más sofisticado aqui si lo queremos asincrono
		//O igual no necesitamos que lo sea
		new Thread() {
			public void run(){
				gestorProductos.insertar(productoDTO.asProducto());
			}
		}.start();		
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/productos/{id}")
	public ResponseEntity<Void> modificarProducto(@RequestBody ProductoDTO productoDTO){
		new Thread() {
			public void run(){
				gestorProductos.modificar(productoDTO.asProducto());				
			}
		}.start();	
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/productos/{referencia}")
	public ResponseEntity<Void> eliminarProducto(@PathVariable("referencia") String referencia) {
		new Thread() {
			public void run(){
				gestorProductos.borrar(referencia);
			}
		}.start();	
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
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
