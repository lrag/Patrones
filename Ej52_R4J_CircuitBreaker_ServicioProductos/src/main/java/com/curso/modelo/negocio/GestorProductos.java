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
	
	public Optional<Producto> buscarProductoYCalificaciones_Sin_CircuitBreaker(String codigo) {
    	return productoRepo
			.findByCodigo(codigo)
			.map(producto -> {
				try {
					List<CalificacionProducto> calificaciones = 
						calificacionesProductosProxy
							.buscarCalificacionesProducto(producto.getCodigo());
					producto.setCalificaciones(calificaciones);
				} catch (Exception e) {
					System.out.println("ZASCA al invocar ServicioCalificacionesProducto");
				}
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
				List<CalificacionProducto> calificaciones = 
					calificacionesProductosProxy
						.buscarCalificacionesProducto(producto.getCodigo());
				producto.setCalificaciones(calificaciones);
				return producto;		
			})
			.or(() -> Optional.empty());
	}
	
    //Este método es una suerte de catch
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
