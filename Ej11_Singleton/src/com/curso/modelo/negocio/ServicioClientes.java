package com.curso.modelo.negocio;

import com.curso.modelo.entidad.Cliente;

public class ServicioClientes {

	//Inicializaci�n ansiosa
	/*
	private static ServicioClientes instancia = new ServicioClientes();

	public static ServicioClientes getInstancia() { 
		return instancia;
	}
	*/

	//Inicializaci�n perezosa
	private static ServicioClientes instancia;
	
	public static synchronized ServicioClientes getInstancia() { 
		//Inicializaci�n perezosa
		if(instancia == null) {
			instancia = new ServicioClientes();
		}
		return instancia;
	}
	
	private ServicioClientes() {		
	}
	
	public void insertar(Cliente cliente) {
		System.out.println("=====================================");
		System.out.println("GestorClientes insertar");
		System.out.println("Cliente:"+cliente);
	}
	
}
