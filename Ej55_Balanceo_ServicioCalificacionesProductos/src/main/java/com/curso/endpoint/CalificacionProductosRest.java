package com.curso.endpoint;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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
	
    @Autowired
    private Environment environment;	
    
	//GET /calificaciones_productos?codigoProducto=XXX
    @GetMapping(path="/calificaciones_productos")
	public List<CalificacionProducto> listarPorProducto(@PathParam("codigoProducto") String codigoProducto){
		System.out.println("=======================================");
        String serverPort = environment.getProperty("local.server.port");
		System.out.println(serverPort+"-Buscando las calificaciones del producto:"+codigoProducto);
		long fin = System.currentTimeMillis()+4000;		
		while(System.currentTimeMillis()<fin) {
			//Haciendo cosas y más cosas
		}		
		
		return calificacionProductoRepo.findAllByCodigoProducto(codigoProducto);
	}	
	
	@PostMapping(path="/calificaciones_productos")
	public ResponseEntity<CalificacionProducto> insertar(@RequestBody() CalificacionProducto cliente){
		CalificacionProducto clienteInsertado = gestorCalificacionesProductos.insertar(cliente);
		return new ResponseEntity<CalificacionProducto>(clienteInsertado, HttpStatus.CREATED);
	}
	
}
