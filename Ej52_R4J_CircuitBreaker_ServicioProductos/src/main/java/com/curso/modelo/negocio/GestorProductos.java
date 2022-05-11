package com.curso.modelo.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.modelo.entidad.CalificacionProducto;
import com.curso.modelo.entidad.Producto;
import com.curso.modelo.persistencia.ProductoRepositorio;
import com.curso.modelo.proxy.CalificacionesProductosProxy;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class GestorProductos {

	@Autowired private ProductoRepositorio productoRepo;
	@Autowired private CalificacionesProductosProxy calificacionesProductosProxy;
	
	///////////////////////
	//SIN CIRCUIT BREAKER//
	///////////////////////
	public Optional<Producto> buscarProductoYCalificaciones_Sin_CircuitBreaker(String codigo) {
    	return productoRepo
			.findByCodigo(codigo)
			.map(producto -> {
				//Si falla la llamada para buscar las calificaciones devolveremos el producto sin ellas
				//Deberíamos indicar en la respuesta lo que ha sucedido				
				List<CalificacionProducto> calificaciones = null;
				try {
					calificaciones = calificacionesProductosProxy.buscarCalificacionesProducto(producto.getCodigo());
				} catch (Exception e) {
					System.out.println("========================================");
					System.out.println("Servicio de calificaciones no disponible!");
					System.out.println(e.getMessage());
				}		
				producto.setCalificaciones(calificaciones);
				return producto;					
			})
			.or(() -> Optional.empty());
	}	
	
    @CircuitBreaker(name = "gestorProductos-buscarProductoYCalificaciones", 
    		        fallbackMethod = "buscarProductoSinCalificaciones")    
	public Optional<Producto> buscarProductoYCalificaciones(String codigo) {
    	System.out.println("Ejecutando el método gestorProductos.buscarProductoYCalificaciones");
    	return productoRepo
			.findByCodigo(codigo)
			.map(producto -> {
				//NO TIENE TRY CATCH
				List<CalificacionProducto> calificaciones = calificacionesProductosProxy
					.buscarCalificacionesProducto(producto.getCodigo());
				producto.setCalificaciones(calificaciones);
				return producto;		
			})
			.or(() -> Optional.empty());
	}
	
    //Este método es una suerte de catch
	public Optional<Producto> buscarProductoSinCalificaciones(String codigo, Exception e) {
		System.out.println(e.getClass());
		//e.printStackTrace();
		System.out.println("========================================");		
		System.out.println("FALLBACK!!!! "+e.getMessage());
		return productoRepo
			.findByCodigo(codigo);
	}  	
	
	public Producto insertar(Producto producto) {
		//Lógica de negocio...
		//...
		return productoRepo.save(producto);
	}
	
	/*
	GestorProductos target;
	Integer fallos = 0;
	Integer umbral = 5;
	
	public Optional<Producto> buscarProductoYCalificaciones(String codigo) {
		
		Optional<Producto> p = null;
		
		if(fallos > 5) {
			return target.buscarProductoSinCalificaciones(codigo, null);
		}

		try {
			p = target.buscarProductoYCalificaciones(codigo);
		} catch (Exception e) {
			//Aumenta el contador de fallos
			fallos++;
			p = target.buscarProductoSinCalificaciones(codigo, e);
		}		
		return p;		
	}
	*/	
	
}
