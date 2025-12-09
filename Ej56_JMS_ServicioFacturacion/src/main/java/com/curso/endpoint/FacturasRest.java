package com.curso.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.modelo.entidad.Factura;
import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.negocio.ServicioFacturas;
import com.curso.modelo.persistencia.FacturaRepositorio;

@RestController
public class FacturasRest {

	@Autowired private ServicioFacturas gestorFacturas;
	@Autowired private FacturaRepositorio facturaRepo;
	
	@GetMapping(path="/facturas/{id}")
	public ResponseEntity<Factura> buscar(@PathVariable("id") Integer id){
		return 
			facturaRepo
				.findById(id)
				.map(c -> new ResponseEntity<Factura>(c, HttpStatus.OK))
				.orElse(new ResponseEntity<Factura>(HttpStatus.NOT_FOUND));
	}

	@GetMapping(path="/facturas")
	public List<Factura> listar(){
		return facturaRepo.findAll();
	}	
	
	@PostMapping(path="/facturas")
	public ResponseEntity<Factura> facturarPedido(@RequestBody() Pedido pedido){
		Factura facturaInsertada = gestorFacturas.facturarPedido(pedido);
		return new ResponseEntity<>(facturaInsertada, HttpStatus.CREATED);
	}
	
}
