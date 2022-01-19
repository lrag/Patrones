package com.curso.persistencia.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.DetallePedido;
import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.entidad.Producto;

public class JpaEntityManagerFactory_PROXY extends JpaEntityManagerFactory {

	private static JpaEntityManagerFactory target;
	private static EntityManagerFactory emf;
    
    public JpaEntityManagerFactory_PROXY(Class[] entityClasses) {
    	super(null); 
    	
    	if(target == null) {
    		Class[] entidades = new Class[]{Cliente.class, Producto.class, Pedido.class, DetallePedido.class};
    		target = new JpaEntityManagerFactory(entidades);
    	}    	
    }
    
    public EntityManager getEntityManager() {
    	return emf.createEntityManager();
    }
    
    public EntityManagerFactory getEntityManagerFactory() {
    	if(emf == null) {
    		emf = target.getEntityManagerFactory();
    	}
    	return emf;
    }
   
}