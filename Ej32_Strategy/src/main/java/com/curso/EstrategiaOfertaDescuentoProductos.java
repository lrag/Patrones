package com.curso;

import java.util.ArrayList;
import java.util.List;

import com.curso.modelo.entidad.DetallePedido;
import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.entidad.Producto;

public class EstrategiaOfertaDescuentoProductos implements EstrategiaOferta{

	private List<Producto> productos;
	private Double descuento;
	
	public EstrategiaOfertaDescuentoProductos(List<Producto> productos, Double descuento) {
		super();
		this.productos = productos;
		this.descuento = descuento;
	}

	@Override
	public void calcularOferta(Pedido pedido) {

		for(DetallePedido dp: pedido.getDetalles()) {
			
			productos
				.stream()
				.filter(p -> p.getId()==dp.getProducto().getId())
				.findFirst()
				.ifPresent(p -> {
					dp.setDescuento(descuento);
				});			
		}
		
	}
	
}
