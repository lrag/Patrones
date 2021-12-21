package com.curso.modelo.persistencia.util;

import com.curso.modelo.persistencia.ClienteRepositorio;
import com.curso.modelo.persistencia.ClienteRepositorioMongoDB;
import com.curso.modelo.persistencia.ClienteRepositorioMysql;

public class FactoriaClienteRepositorio {

	//Esto se ha leído de la configuracion
	private static String tipo = "Mysql";
	
	public static ClienteRepositorio getClienteRepositorio() {
		switch(tipo) {
			case "Mysql"   : return ClienteRepositorioMysql.getInstancia();
			case "MongoDB" : return ClienteRepositorioMongoDB.getInstancia();
			default : throw new RuntimeException("Error de configuración");
		}
	}
	
	//Una factory method tambien puede recibir indicaciones del objeto que tiene que crear 
	public static ClienteRepositorio getClienteRepositorio(String tipo) {
		switch(tipo) {
			case "Mysql"   : return ClienteRepositorioMysql.getInstancia();
			case "MongoDB" : return ClienteRepositorioMongoDB.getInstancia();
			default : throw new RuntimeException("Error de configuración");
		}
	}
	
	private FactoriaClienteRepositorio() {
	}
	
}
