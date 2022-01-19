package com.curso.persistencia.transacciones;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.curso.persistencia.jpa.JpaEntityManagerFactory_PROXY;

public class GestorTransacciones {

	private static EntityManagerFactory emf = new JpaEntityManagerFactory_PROXY(null).getEntityManagerFactory();
	private static Map<Long, DatosTransaccion> ems = new HashMap<>();
	
	private static DatosTransaccion getDatosTransaccion() {		
		Long thId = Thread.currentThread().getId();
		DatosTransaccion datosTx = ems.get(thId);
		if(datosTx == null) {
			datosTx = new DatosTransaccion(emf.createEntityManager(), 1);
			ems.put(thId, datosTx);
		}
		return datosTx;
	}
	
	static EntityManager getEntityManager() {		
		System.out.println("GET EM");
		return getDatosTransaccion().em;
	}
	
	public static void beginTX() {
		System.out.println("BEGIN TX");
		DatosTransaccion datosTx = getDatosTransaccion();
		EntityManager em = datosTx.em;
		if(!em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}
		datosTx.contador++;
	}
	
	public static void commitTX() {
		System.out.println("COMMIT TX");
		DatosTransaccion datosTx = getDatosTransaccion();
		EntityManager em = datosTx.em;
		datosTx.contador--;		
		if(datosTx.contador == 0) {
			em.getTransaction().commit();
		}
	}

	public static void rollbackTX() {
		System.out.println("ROLLBACK TX");
		DatosTransaccion datosTx = getDatosTransaccion();
		EntityManager em = datosTx.em;
		datosTx.contador--;		
		if(datosTx.contador == 0) {
			em.getTransaction().rollback();
		}	
	}
	
}
