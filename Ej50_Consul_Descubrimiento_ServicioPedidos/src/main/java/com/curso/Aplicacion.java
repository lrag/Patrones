package com.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.modelo.negocio.GestorPedidos;
import com.curso.modelo.persistencia.ClienteRepositorio;
import com.curso.modelo.persistencia.PedidoRepositorio;

/*
{
	"fecha" : "27/11/2023",
	"estado" : "pendiente",
	"cliente" : {
		"login" : "sam"
	},
	"detalles" : [
		{
			"producto" : {
				"codigo" : "PROD-1"
			},
			"cantidad" : 1
		},
		{
			"producto" : {
				"codigo" : "PROD-3"
			},
			"cantidad" : 2
		},
		{
			"producto" : {
				"codigo" : "PROD-5"
			},
			"cantidad" : 3
		}	
	]
}
*/

@SpringBootApplication
public class Aplicacion implements CommandLineRunner {

	@Autowired private ClienteRepositorio clienteRepo;
	@Autowired private PedidoRepositorio pedidoRepo;
	@Autowired private GestorPedidos gestorPedidos;
	
	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("================================");
		/*
		if(clienteRepo.count() == 0) {
			clienteRepo.save(new Cliente(null,"philip","Philip Marlowe","banco 2"));
		}
		*/
		
		//System.out.println("================================");
		//pedidoRepo.findAll().forEach( p -> System.out.println(p.getDetalles()));
		
		/*
		Pedido p = new Pedido();
		Cliente c = new Cliente();
		c.setLogin("sam");
		p.setCliente(c);
		
		Producto p1 = new Producto();
		p1.setCodigo("PROD-1");
		Producto p2 = new Producto();
		p2.setCodigo("PROD-3");
		
		DetallePedido dp1 = new DetallePedido();
		dp1.setProducto(p1);
		dp1.setCantidad(1);
		
		DetallePedido dp2 = new DetallePedido();
		dp2.setProducto(p2);
		dp2.setCantidad(5);
		
		List<DetallePedido> detalles = new ArrayList<>();
		detalles.add(dp1);
		detalles.add(dp2);
		
		p.setDetalles(detalles);
		
		gestorPedidos.altaPedido(p);
		*/
		
	}

}
