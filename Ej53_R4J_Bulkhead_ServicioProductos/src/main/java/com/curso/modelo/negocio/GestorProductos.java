package com.curso.modelo.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.modelo.entidad.CalificacionProducto;
import com.curso.modelo.entidad.Producto;
import com.curso.modelo.persistencia.ProductoRepositorio;
import com.curso.modelo.proxy.CalificacionesProductosProxy;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;

@Service
public class GestorProductos {

	@Autowired private ProductoRepositorio productoRepo;
	@Autowired private CalificacionesProductosProxy calificacionesProductosProxy;
	
	//Podemos tener @CircuitBreaker y @BulkHead simultaneamente sin problemas
    //@CircuitBreaker(name = "gestorProductos-buscarProductoYCalificaciones", fallbackMethod = "buscarProductoSinCalificaciones")    
    @Bulkhead(name = "gestorProductos-buscarProductoYCalificaciones", 
        	  fallbackMethod = "buscarProductoSinCalificaciones", 
        	  type = Bulkhead.Type.SEMAPHORE)
	public Optional<Producto> buscarProductoYCalificaciones(String codigo) {
		return productoRepo
			.findByCodigo(codigo)
			.map(producto -> {
				List<CalificacionProducto> calificaciones = 
					calificacionesProductosProxy
						.buscarCalificacionesProducto(producto.getCodigo());
				producto.setCalificaciones(calificaciones);
				return producto;		
			})
			.or(() -> Optional.empty());
	}
    
	public Optional<Producto> buscarProductoSinCalificaciones(String codigo, Exception e) {
		System.out.println("!!!! "+e.getMessage());
		return productoRepo
			.findByCodigo(codigo);
	}  	  
	
	public Producto insertar(Producto producto) {
		//Lógica de negocio...
		//...
		return productoRepo.save(producto);
	}
	
}
