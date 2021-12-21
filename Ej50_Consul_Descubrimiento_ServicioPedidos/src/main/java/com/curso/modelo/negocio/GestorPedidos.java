package com.curso.modelo.negocio;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.DetallePedido;
import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.entidad.Producto;
import com.curso.modelo.persistencia.ClienteRepositorio;
import com.curso.modelo.persistencia.DetallePedidoRepositorio;
import com.curso.modelo.persistencia.PedidoRepositorio;
import com.curso.modelo.persistencia.ProductoRepositorio;
import com.curso.modelo.proxy.ClientesRestProxy;
import com.curso.modelo.proxy.ProductosRestProxy;

@Service
@Transactional
public class GestorPedidos {

	@Autowired private ClienteRepositorio clienteRepo;
	@Autowired private PedidoRepositorio pedidoRepo;
	@Autowired private ProductoRepositorio productoRepo;
	
	@Autowired private ClientesRestProxy clientesRestProxy;
	@Autowired private ProductosRestProxy productosRestProxy;
	
	public Pedido altaPedido(Pedido pedido) {

		System.out.println("===============================");
		System.out.println("Alta pedido");
		
		//Buscamos al cliente a partir de su login
		String login = pedido.getCliente().getLogin();			
		System.out.println("Login del cliente:"+login);
		Cliente cliente = clienteRepo
			.findByLogin(login)
			.orElseGet( () -> {
				System.out.println("Invocando al microservicio de clientes");
				Cliente cliAux = clientesRestProxy.buscar(login);
				System.out.println("Cliente obtenido:"+cliAux);
				clienteRepo.save(cliAux);
				return cliAux;
			});
		pedido.setCliente(cliente);
		
		//Comprobamos los datos bancarios
		//...

		//Calculamos el total
		Double total = 0d;
		for(DetallePedido dp : pedido.getDetalles()) {
			String codigoProducto = dp.getProducto().getCodigo();
			Producto producto = productoRepo
				.findByCodigo(codigoProducto)
				.orElseGet( () -> {
					System.out.println("Invocando al microservicio de productos");
					Producto prodAux = productosRestProxy.buscar(codigoProducto);
					System.out.println("prodAux:"+prodAux);
					productoRepo.save(prodAux);
					return prodAux;					
				});
			dp.setProducto(producto);
			dp.setPrecio(producto.getPrecio());
			dp.setPedido(pedido);
			total += producto.getPrecio()*dp.getCantidad();
		}
		pedido.setTotal(total);
		
		//Le asignamos un codigo al pedido
		pedido.setCodigo("PED-"+Math.round(System.currentTimeMillis()/1000));
		
		//Y lo insertamos
		pedidoRepo.save(pedido);
		
		return pedido;
	}

	public void modificar(Pedido pedido) {
		// TODO Auto-generated method stub		
	}

	public void borrar(Integer idPedido) {
		// TODO Auto-generated method stub		
	}	
	
}










