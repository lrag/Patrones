 package com.curso.modelo.persistencia.util;

import com.curso.modelo.persistencia.ClienteRepositorio;
import com.curso.modelo.persistencia.ClienteRepositorioMongoDB;
import com.curso.modelo.persistencia.ClienteRepositorioMysql;

public class FactoriaClienteRepositorio {

	//Esto se ha le�do de la configuraci�n
	private static String tipo = "Mysql";
	
	public synchronized static ClienteRepositorio getClienteRepositorio() {
		switch(tipo) {
			case "Mysql"   : return ClienteRepositorioMysql.getInstancia();
			case "MongoDB" : return ClienteRepositorioMongoDB.getInstancia();
			default : throw new RuntimeException("Error de configuraci�n");
		}
	}
	
	//Un factory method tambien puede recibir indicaciones del objeto que tiene que crear 
	public synchronized static ClienteRepositorio getClienteRepositorio(String tipo) {
		switch(tipo) {
			case "Mysql"   : return ClienteRepositorioMysql.getInstancia();
			case "MongoDB" : return ClienteRepositorioMongoDB.getInstancia();
			default : throw new RuntimeException("Error de configuraci�n");
		}
	}
	
	private FactoriaClienteRepositorio() {
	}
	
}
