package com.curso;

import com.curso.modelo.negocio.ServicioClientes;

public class Prueba {

	public static void main(String[] args) {
		
		//GestorClientes gc = new GestorClientes();
		
		ServicioClientes gc1 = ServicioClientes.getInstancia();
		ServicioClientes gc2 = ServicioClientes.getInstancia();
		ServicioClientes gc3 = ServicioClientes.getInstancia();
		ServicioClientes gc4 = ServicioClientes.getInstancia();
		
		System.out.println(gc1);
		System.out.println(gc2);
		System.out.println(gc3);
		System.out.println(gc4);
		
	}
	
}
