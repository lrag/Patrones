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
import com.curso.modelo.comandos.Comando;
import com.curso.modelo.comandos.ComandoBorrarProducto;
import com.curso.modelo.comandos.ComandoInsertarProducto;
import com.curso.modelo.comandos.ComandoModificarProducto;
import com.curso.modelo.comandos.cola.ColaComandos;
import com.curso.modelo.negocio.GestorProductos;
import com.curso.modelo.repositorio.RepositorioProductos;

@RestController
public class ProductosEndpoint {
	
	@Autowired private GestorProductos gestorProductos;
	@Autowired private ColaComandos colaComandos;

	@PostMapping("/productos")
	public ResponseEntity<Void> altaProducto(@RequestBody ProductoDTO productoDTO){
		Comando comando = new ComandoInsertarProducto(productoDTO.asProducto(), gestorProductos);
		colaComandos.offer(comando);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/productos/{referencia}")
	public ResponseEntity<Void> modificarProducto(@RequestBody ProductoDTO productoDTO, @PathVariable("referencia") String referencia){
		productoDTO.setReferencia(referencia);
		Comando comando = new ComandoModificarProducto(productoDTO.asProducto(), gestorProductos);
		colaComandos.offer(comando);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/productos/{referencia}")
	public ResponseEntity<Void> eliminarProducto(@PathVariable("referencia") String referencia) {
		Comando comando = new ComandoBorrarProducto(referencia, gestorProductos);
		colaComandos.offer(comando);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
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
