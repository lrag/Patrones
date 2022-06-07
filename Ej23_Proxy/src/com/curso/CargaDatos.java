package com.curso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.DetallePedido;
import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.entidad.Producto;
import com.curso.persistencia.jpa.JpaEntityManagerFactory_PROXY;

public class CargaDatos {

	public static void main(String[] args) {

		EntityManagerFactory emf = new JpaEntityManagerFactory_PROXY(null).getEntityManagerFactory();
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.createQuery("delete from DetallePedido").executeUpdate();
		em.createQuery("delete from Producto").executeUpdate();
		em.createQuery("delete from Pedido").executeUpdate();
		em.createQuery("delete from Cliente").executeUpdate();
		
		Producto p1 = new Producto(null, "P1", "F1", 25d, 1000);
		Producto p2 = new Producto(null, "P2", "F2", 50d, 1000);
		Producto p3 = new Producto(null, "P3", "F3", 75d, 1000);
		Producto p4 = new Producto(null, "P4", "F4", 100d, 1000);
		Producto p5 = new Producto(null, "P5", "F5", 125d, 1000);
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);		
		em.persist(p4);
		em.persist(p5);
		
		Cliente c1 = new Cliente(null, "Harpo", "Su casa", "123", 1);
		Cliente c2 = new Cliente(null, "Mongomery Burns", "Su mansi�n", "123", 9999);
		
		Pedido pedido1 = new Pedido(null, "PED-0", LocalDate.now(), "PENDIENTE", c1, null);
		List<DetallePedido> detalles1 = new ArrayList<DetallePedido>();
		detalles1.add(new DetallePedido(null, pedido1, p2, 25d, 25));
		detalles1.add(new DetallePedido(null, pedido1, p4, 25d, 25));
		pedido1.setDetalles(detalles1);

		Pedido pedido2 = new Pedido(null, "PED-1", LocalDate.now(), "PENDIENTE", c2, null);
		List<DetallePedido> detalles2 = new ArrayList<DetallePedido>();
		detalles2.add(new DetallePedido(null, pedido2, p1, 25d, 25));
		detalles2.add(new DetallePedido(null, pedido2, p3, 75d, 25));
		detalles2.add(new DetallePedido(null, pedido2, p5, 125d, 25));
		pedido2.setDetalles(detalles2);
		
		Pedido pedido3 = new Pedido(null, "PED-2", LocalDate.now(), "PENDIENTE", c2, null);
		List<DetallePedido> detalles3 = new ArrayList<DetallePedido>();
		detalles3.add(new DetallePedido(null, pedido3, p1, 25d, 25));
		detalles3.add(new DetallePedido(null, pedido3, p3, 75d, 25));
		detalles3.add(new DetallePedido(null, pedido3, p5, 125d, 2500));
		pedido3.setDetalles(detalles3);

		em.persist(c1);
		em.persist(c2);
		
		em.persist(pedido1); //Id: 1
		em.persist(pedido2); //Id: 2
		em.persist(pedido3); //Id: 3
		
		em.getTransaction().commit();
		em.close();		
		
		
	}
	
}
