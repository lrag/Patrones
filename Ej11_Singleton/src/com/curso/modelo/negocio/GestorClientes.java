package com.curso.modelo.negocio;

import com.curso.modelo.entidad.Cliente;

public class GestorClientes {
	
	private static GestorClientes instancia;
	
	public static synchronized GestorClientes getInstancia() { 
		//Inicialización perezosa
		if(instancia == null) {
			instancia = new GestorClientes();
		}
		return instancia;
	}
	
	private GestorClientes() {		
	}
	
	public void insertar(Cliente cliente) {
		System.out.println("=====================================");
		System.out.println("GestorClientes insertar");
		System.out.println("Cliente:"+cliente);
	}
}
