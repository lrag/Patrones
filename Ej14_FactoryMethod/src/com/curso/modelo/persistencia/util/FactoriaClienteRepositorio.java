package com.curso.modelo.persistencia.util;

import com.curso.modelo.persistencia.ClienteRepositorio;
import com.curso.modelo.persistencia.ClienteRepositorioMongoDB;
import com.curso.modelo.persistencia.ClienteRepositorioMysql;

public class FactoriaClienteRepositorio {

	private static String tipo = "Mysql";
	
	public static ClienteRepositorio getClienteRepositorio() {
		switch(tipo) {
			case "Mysql"   : return ClienteRepositorioMysql.getInstancia();
			case "MongoDB" : return ClienteRepositorioMongoDB.getInstancia();
			default : throw new RuntimeException("Error de configuración");
		}
	}
	
}
