package com.curso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.DetallePedido;
import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.entidad.Producto;

public class Aplicacion {

	static Producto p1 = new Producto(1, "P1", "F1", 25d, 1000);
	static Producto p2 = new Producto(2, "P2", "F2", 50d, 1000);
	static Producto p3 = new Producto(3, "P3", "F3", 75d, 1000);
	static Producto p4 = new Producto(4, "P4", "F4", 100d, 1000);
	static Producto p5 = new Producto(5, "P5", "F5", 125d, 1000);

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) {
		
		/*
		EstrategiaOfertaCero sinOferta = new EstrategiaOfertaCero();
		EstrategiaOfertaDescuentoGlobal ofertaDiezPorCiento = new EstrategiaOfertaDescuentoGlobal(10d);
		EstrategiaOfertaDescuentoGlobal ofertaVeintePorCiento = new EstrategiaOfertaDescuentoGlobal(20d);
		EstrategiaOfertaPerritoPiloto ofertaPerritoPiloto = new EstrategiaOfertaPerritoPiloto();
		*/
		EstrategiaOferta sinOferta             = new EstrategiaOfertaCero();
		EstrategiaOferta ofertaDiezPorCiento   = new EstrategiaOfertaDescuentoGlobal(10d);
		EstrategiaOferta ofertaVeintePorCiento = new EstrategiaOfertaDescuentoGlobal(20d);
		EstrategiaOferta ofertaPerritoPiloto   = new EstrategiaOfertaPerritoPiloto();
		
		List<Producto> productosOferta = Arrays.asList(p2,p3,p5);
		EstrategiaOferta3x2 oferta3x2 = new EstrategiaOferta3x2(productosOferta);
		EstrategiaOfertaDescuentoProductos ofertaDescuentoProductos = new EstrategiaOfertaDescuentoProductos(productosOferta, 10d);
		
		ServicioPedidos sp = new ServicioPedidos();
		
		sp.aceptarPedido(getPedido1(), ofertaDiezPorCiento);
		sp.aceptarPedido(getPedido1(), ofertaVeintePorCiento);
		
		sp.aceptarPedido(getPedido1(), ofertaPerritoPiloto);
		sp.aceptarPedido(getPedido2(), sinOferta);
		sp.aceptarPedido(getPedido2(), oferta3x2);
		sp.aceptarPedido(getPedido2(), ofertaDescuentoProductos);
		
		sp.aceptarPedido(getPedido1(), pedido -> { 
				pedido.setDescuento(pedido.getTotal()*(10/100));
				pedido.calcularTotal();			
			} ); //ofertaDiezPorCiento);
		
	}
	
	
	public static Cliente getCliente() {
		LocalDate fechaAlta = LocalDate.parse("10/10/2000", dtf);		
		return new Cliente(1,"Harry Callahan","S.F.","555",6500, fechaAlta);
	}
	
	public static Pedido getPedido1() {
		Cliente c = getCliente();
		Pedido pedido1 = new Pedido(null, "PED-1", LocalDate.now(), "PENDIENTE", c, null);
		List<DetallePedido> detalles = new ArrayList<DetallePedido>();
		detalles.add(new DetallePedido(null, pedido1, p1, 25d, 1, 0d));
		detalles.add(new DetallePedido(null, pedido1, p3, 75d, 1, 0d));
		detalles.add(new DetallePedido(null, pedido1, p5, 125d, 1, 0d));		
		pedido1.setDetalles(detalles);
		return pedido1;
	}

	public static Pedido getPedido2() {		
		Cliente c = getCliente();
		Pedido pedido2 = new Pedido(null, "PED-1", LocalDate.now(), "PENDIENTE", c, null);
		List<DetallePedido> detalles2 = new ArrayList<DetallePedido>();
		detalles2.add(new DetallePedido(null, pedido2, p1, 25d, 3, 0d));
		detalles2.add(new DetallePedido(null, pedido2, p3, 75d, 3, 0d));
		detalles2.add(new DetallePedido(null, pedido2, p5, 125d, 2, 0d));		
		pedido2.setDetalles(detalles2);
		return pedido2;
	}
	
}

/*
class Movida implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println(">>>"+t);
		
	}	
	
}
*/

