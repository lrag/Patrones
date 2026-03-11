 package com.curso.modelo.persistencia.util;

import javax.sql.DataSource;

import com.curso.modelo.persistencia.FacturaRepositorio;
import com.curso.modelo.persistencia.FacturaRepositorioMysql;

public class FactoriaFacturaRepositorio {

	//Esto se ha leído de la configuración
	private static String tipo = "Mysql";
	
	private static FacturaRepositorio facturaRepositorio;
	
	public synchronized static FacturaRepositorio getFacturaRepositorio(DataSource dataSource) {
		
		if(facturaRepositorio == null) {
			switch(tipo) {
				case "Mysql"   : facturaRepositorio = new FacturaRepositorioMysql(dataSource);
				                 break;
				//case "MongoDB" : return ClienteRepositorioMongoDB.getInstancia();
				default : throw new RuntimeException("Error de configuración");
			}
		}
		
		return facturaRepositorio;
	}
	
	private FactoriaFacturaRepositorio() {
	}
	
}
