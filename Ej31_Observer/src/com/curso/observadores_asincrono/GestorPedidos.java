package com.curso.observadores_asincrono;

import com.curso.modelo.entidad.Pedido;
import com.curso.util.eventos.SujetoPedidos;
import com.curso.util.eventos.SujetoPedidosAsincrono;

public class GestorPedidos {

	private SujetoPedidosAsincrono sujetoPedidos = SujetoPedidosAsincrono.getInstancia();
	
	//Estas son las dependencias de esta clase
	//private GestorClientes gestorClientes;
	//private GestorAlmacen gestorAlmacen;
	//private GestorCatalogo gestorCatalogo;
	
	public void crearOrdenDeCompra(Pedido pedido) {
		
		//Lógica de negocio para aceptar el pedido
		
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
