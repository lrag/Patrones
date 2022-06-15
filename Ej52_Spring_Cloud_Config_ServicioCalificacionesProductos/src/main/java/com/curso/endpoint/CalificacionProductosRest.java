package com.curso.endpoint;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.modelo.entidad.CalificacionProducto;
import com.curso.modelo.negocio.GestorCalificacionesProducto;
import com.curso.modelo.persistencia.CalificacionProductoRepository;

@RestController
public class CalificacionProductosRest {

	@Autowired private GestorCalificacionesProducto gestorCalificacionesProductos;
	@Autowired private CalificacionProductoRepository calificacionProductoRepo;
	
	@GetMapping(path="/calificaciones_productos/{id}")
	public ResponseEntity<CalificacionProducto> buscar(@PathVariable("id") Integer id){
		return calificacionProductoRepo
				.findById(id)
				.map(c -> new ResponseEntity<CalificacionProducto>(c, HttpStatus.OK))
				.orElse(new ResponseEntity<CalificacionProducto>(HttpStatus.NOT_FOUND));
	}

	/*
	//Otra opción
	@GetMapping(path="/producto/{codigoProducto}/calificaciones")
	public List<CalificacionProducto> listarPorProducto(@PathVariable("codigoProducto") String codigoProducto){
		return calificacionProductoRepo.findAllByCodigoProducto(codigoProducto);
	}
	*/	

	//GET /calificaciones_productos?codigoProducto=XXX
	@GetMapping(path="/calificaciones_productos")
	public List<CalificacionProducto> listarPorProducto(@PathParam("codigoProducto") String codigoProducto){

		System.out.println("=======================================");
		System.out.println("Buscando las calificaciones del producto:"+codigoProducto);
		long fin = System.currentTimeMillis()+4000;
		while(System.currentTimeMillis()<fin) {
			//Haciendo cosas y más cosas
		}
		
		return calificacionProductoRepo.findAllByCodigoProducto(codigoProducto);
	}	
	
	@PostMapping(path="/calificaciones_productos")
	public ResponseEntity<CalificacionProducto> insertar(@RequestBody() CalificacionProducto calificacion){
		CalificacionProducto clienteInsertado = gestorCalificacionesProductos.insertar(calificacion);
		return new ResponseEntity<CalificacionProducto>(clienteInsertado, HttpStatus.CREATED);
	}
	
}
