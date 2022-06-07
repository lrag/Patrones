package com.curso;

import java.util.ArrayList;
import java.util.List;

import com.curso.modelo.entidad.DetallePedido;
import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.entidad.Producto;

public class EstrategiaOferta3x2 implements EstrategiaOferta{

	private List<Producto> productos3x2;
	
	public EstrategiaOferta3x2(List<Producto> productos3x2) {
		super();
		this.productos3x2 = productos3x2;
	}

	@Override
	public void calcularOferta(Pedido pedido) {

		List<DetallePedido> detalles3x2 = new ArrayList();
		for(DetallePedido dp: pedido.getDetalles()) {
			
			if(dp.getCantidad()!=3) {
				continue;
			}
			
			productos3x2
				.stream()
				.filter(p -> p.getId()==dp.getProducto().getId())
				.findFirst()
				.ifPresent(p -> {
					Producto pp = new Producto(p.getId(), p.getNombre(), p.getFabricante(), p.getPrecio(), 0);
					DetallePedido detalle3x2 = new DetallePedido(null, pedido, pp, dp.getPrecio()*-1, 1, 0d);
					detalles3x2.add(detalle3x2);
				});			
		}
		
		detalles3x2.forEach(dp -> pedido.addDetalle(dp));
		
		
	}
	
}
