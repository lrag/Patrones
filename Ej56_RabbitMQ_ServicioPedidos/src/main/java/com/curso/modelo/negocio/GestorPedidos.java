package com.curso.modelo.negocio;

import javax.transaction.Transactional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.endpoint.dto.PedidoDTO;
import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.DetallePedido;
import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.entidad.Producto;
import com.curso.modelo.persistencia.PedidoRepositorio;
import com.curso.modelo.proxy.ClientesRestProxy;
import com.curso.modelo.proxy.ProductosRestProxy;

@Service
@Transactional(rollbackOn = { Exception.class } )
public class GestorPedidos {

	@Autowired private PedidoRepositorio pedidoRepo;
	@Autowired private ClientesRestProxy clientesRestProxy;
	@Autowired private ProductosRestProxy productosRestProxy;
	@Autowired private RabbitTemplate rabbitTemplate;
	
	public Pedido altaPedido(Pedido pedido) {

		System.out.println("===============================");
		System.out.println("Alta pedido");
		
		//Buscamos al cliente a partir de su login
		String login = pedido.getCliente().getLogin();			
		System.out.println("Login del cliente:"+login);
		Cliente cliente = clientesRestProxy.buscar(login);
		pedido.setCliente(cliente);
		
		//Comprobamos los datos bancarios
		//...

		//Calculamos el total
		Double total = 0d;
		for(DetallePedido dp : pedido.getDetalles()) {
			String codigoProducto = dp.getProducto().getCodigo();
			Producto producto = productosRestProxy.buscar(codigoProducto);
			dp.setProducto(producto);
			dp.setPrecio(producto.getPrecio());
			dp.setPedido(pedido);
			total += producto.getPrecio()*dp.getCantidad();
		}
		pedido.setTotal(total);
		
		//Le asignamos un codigo al pedido
		pedido.setCodigo("PED-"+Math.round(System.currentTimeMillis()/1000));
		//Cambiamos el estado a ACEPTADO
		pedido.setEstado("ACEPTADO");
		
		//Y lo insertamos
		pedidoRepo.save(pedido);
		
		//Enviamos un mensaje a la cola de pedidos aceptados
		//Ese mensaje lo recogerá ServicioFacturacion y cualquier otro que esté subscrito
		//De esta manera ServicioPedidos puede 'ordenar' al ServicioFacturas que emita 
		//una factura SIN CONOCERLO
		//
		//Y aqui deberiamos estar utilizando un PROXY!
		//		
		rabbitTemplate.convertAndSend("colaOrdenesDeCompra",new PedidoDTO(pedido));	

		/*
		System.out.println("------------------------------------");
		System.out.println("Iniciando espera");
		try {
			Thread.sleep(10_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("YA");
		System.out.println("------------------------------------");
		
		if(1==1) {
			System.out.println("ZASCA");
			throw new RuntimeException("ZASCA TARRASCA");
		}
		*/
		
		return pedido;
	}

	public void modificar(Pedido pedido) {
		// TODO Auto-generated method stub		
	}

	public void borrar(Integer idPedido) {
		// TODO Auto-generated method stub		
	}	
	
}










