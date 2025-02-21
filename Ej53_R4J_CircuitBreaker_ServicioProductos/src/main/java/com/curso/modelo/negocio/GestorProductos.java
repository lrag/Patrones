package com.curso.modelo.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.modelo.entidad.CalificacionProducto;
import com.curso.modelo.entidad.Producto;
import com.curso.modelo.persistencia.ProductoRepositorio;
import com.curso.modelo.proxy.CalificacionesProductosProxy;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
@Transactional
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
					calificaciones = new ArrayList<>();
				}		
				producto.setCalificaciones(calificaciones);
				return producto;					
			})
			.or(() -> Optional.empty());
	}	
	
	
	@CircuitBreaker(name = "gestorProductos-buscarProductoYCalificaciones", 
    		        fallbackMethod = "fallbackBuscarProductoYCalificaciones")    
	public Optional<Producto> buscarProductoYCalificaciones(String codigo) throws Exception{
		System.out.println("========================================");		
		System.out.println("Ejecutando el método gestorProductos.buscarProductoYCalificaciones");
		return productoRepo
			.findByCodigo(codigo)
			.map(producto -> {
				
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				//NO TIENE TRY-CATCH
				List<CalificacionProducto> calificaciones = calificacionesProductosProxy
					.buscarCalificacionesProducto(producto.getCodigo());
				producto.setCalificaciones(calificaciones);
				return producto;		
			})
			.or(() -> Optional.empty());
	}
	
    //Este método es una suerte de catch
	public Optional<Producto> fallbackBuscarProductoYCalificaciones(String codigo, Exception e) throws Exception {
		System.out.println("========================================");		
		System.out.println(e.getClass());
		//e.printStackTrace();
		System.out.println("FALLBACK!!!! "+e.getMessage());
		throw new Exception("No se pudo buscar el producto con sus calificaciones :(");
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
			p = target.fallbackBuscarProductoYCalificaciones(codigo, e);
		}		
		return p;		
	}
	*/	
	
}
