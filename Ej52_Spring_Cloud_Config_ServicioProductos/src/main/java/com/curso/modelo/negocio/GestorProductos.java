package com.curso.modelo.negocio;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.modelo.entidad.CalificacionProducto;
import com.curso.modelo.entidad.Producto;
import com.curso.modelo.persistencia.ProductoRepositorio;
import com.curso.modelo.proxy.CalificacionesProductosProxy;

@Service
public class GestorProductos {

	@Autowired private ProductoRepositorio productoRepo;
	@Autowired private CalificacionesProductosProxy calificacionesProductosProxy;

	public Optional<Producto> buscarProductoYCalificaciones(String codigo) {
		return productoRepo
			.findByCodigo(codigo)
			.map(producto -> {	
				//Si falla la llamada para buscar las calificaciones devolveremos el producto sin ellas
				//Deberiamos indicar de algún en la respuesta lo que ha sucedido				
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
	
	public Producto insertar(Producto producto) {
		//Lógica de negocio...
		//...
		return productoRepo.save(producto);
	}
	
}
