package com.curso.observadores_asincrono;

import com.curso.modelo.entidad.Pedido;
import com.curso.util.eventos_asincrono.SujetoPedidosAsincrono;

public class ServicioPedidos {

	private SujetoPedidosAsincrono sujetoPedidos = SujetoPedidosAsincrono.getInstancia();
	
	//Estas son lass dependencias de esta clase
	//private GestorClientes gestorClientes;
	//private GestorAlmacen gestorAlmacen;
	//private GestorCatalogo gestorCatalogo;

	public void crearOrdenDeCompra(Pedido pedido) {
		
		//L�gica de negocio para aceptar el pedido
		
		//buscar los datos del cliente
		//Cliente c = servicioClientes.buscar(pedido.getCliente())
		//buscar el precio de los productos: sincron y reservarlas: sincronno
		
		System.out.println("=====================================");
		System.out.println("GestorPedidos.altaPedido");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		sujetoPedidos.emitir(pedido);
	}
	
}
