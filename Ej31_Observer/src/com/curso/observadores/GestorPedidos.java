package com.curso.observadores;

import com.curso.modelo.entidad.Pedido;
import com.curso.util.eventos.SujetoPedidos;

public class GestorPedidos {

	private SujetoPedidos sujetoPedidos = SujetoPedidos.getInstancia();
	
	//Estas serian las dependencias de esta clase, con las que está de verdad acoplada
	//private GestorClientes gestorClientes;
	//private GestorAlmacen gestorAlmacen;
	//private GestorCatalogo gestorCatalogo;
	
	public void crearOrdenDeCompra(Pedido pedido) {
		
		//Lógica de negocio para aceptar el pedido
		
		//buscar los datos del cliente
		//Cliente c = servicioClientes.buscar(pedido.getCliente())
		//buscar el precio de los productos: sincrono
		//reservarla los productos en el almacen: sincronno
		
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
