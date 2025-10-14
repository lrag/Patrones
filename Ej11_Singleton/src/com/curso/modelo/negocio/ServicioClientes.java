package com.curso.modelo.negocio;

import com.curso.modelo.entidad.Cliente;

public class ServicioClientes {

	//Inicialización ansiosa
	/*
	private static ServicioClientes instancia = new ServicioClientes();

	public static ServicioClientes getInstancia() { 
		return instancia;
	}
	*/

	//Inicialización perezosa
	private static ServicioClientes instancia;
	
	public static synchronized ServicioClientes getInstancia() { 
		//Inicialización perezosa
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
