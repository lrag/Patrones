package com.curso.modelo.mensajeria;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;

import org.springframework.stereotype.Component;

import com.curso.endpoint.dto.PedidoDTO;
import com.curso.modelo.entidad.Pedido;

@Component
public class SupplierOrdenesCompra implements Supplier<PedidoDTO>{

	private BlockingQueue<PedidoDTO> cola = new LinkedBlockingQueue<>();
	
	public void enviarPedido(Pedido pedido) {	
		System.out.println("Recibido el pedido vía HTTP:"+pedido);
		cola.offer(new PedidoDTO(pedido));
	}	
	
	@Override
	public PedidoDTO get() {
		PedidoDTO pedido = null;
		try {
			System.out.println("==================================================");
			System.out.println("cola.take()");
			pedido = cola.take();
			System.out.println("pedido extraido de la cola!");
		} catch (InterruptedException e) {
			System.out.println("==================================================");
			System.out.println("TAKE");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return pedido;
	}
	
	/*
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> cola = new LinkedBlockingQueue<>();
		cola.offer("HOLA");
		System.out.println(cola.take());
		System.out.println(cola.take());
		System.out.println("FIN");
	}
	*/
	
}

























