package com.curso.persistencia.jpa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceUnitInfo;

import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;
import org.hibernate.jpa.boot.internal.PersistenceUnitInfoDescriptor;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.DetallePedido;
import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.entidad.Producto;
import com.curso.persistencia.datasource.DataSourceUtil;

public class JPAUtil {
	
	private static EntityManagerFactory emf;	
	
    public static EntityManager getEntityManager() {
    	if(emf == null) {
    		getEntityManagerFactory();
    	}    	
        return getEntityManagerFactory().createEntityManager();
    }
    
    public static EntityManagerFactory getEntityManagerFactory() {
    	if(emf == null) {
	        PersistenceUnitInfo persistenceUnitInfo = getPersistenceUnitInfo("JPA_PU");
	        Map<String, Object> configuration = new HashMap<>();
	        emf = new EntityManagerFactoryBuilderImpl(
	          new PersistenceUnitInfoDescriptor(persistenceUnitInfo), configuration)
	          .build();
    	}
        
        return emf;       
    }
    
    private static HibernatePersistenceUnitInfo getPersistenceUnitInfo(String name) {
        return new HibernatePersistenceUnitInfo(name, getEntityClassNames(), getProperties());
    }
    
    private static List<String> getEntityClassNames() {
        return Arrays.asList(getEntities())
          .stream()
          .map(Class::getName)
          .collect(Collectors.toList());
    }
    
    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.id.new_generator_mappings", false);
        properties.put("hibernate.connection.datasource", DataSourceUtil.getDataSource());
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "false");
        return properties;
    }
    
    private static Class[] getEntities() {
		return new Class[]{Cliente.class, Producto.class, Pedido.class, DetallePedido.class};
    }
    
}