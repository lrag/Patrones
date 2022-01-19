package com.curso.modelo.persistencia.util;

import com.curso.modelo.persistencia.ClienteRepositorio;
import com.curso.modelo.persistencia.ClienteRepositorioMysql;

public class FactoriaRepositorios {

	//Esto se ha leído de la configuracion
	private static String tipo = "Mysql";
	
	public static ClienteRepositorio getClienteRepositorio() {
		switch(tipo) {
			case "Mysql"   : return ClienteRepositorioMysql.getInstancia();
			default : throw new RuntimeException("Error de configuración");
		}
	}
	
	private FactoriaRepositorios() {
	}
	
}
