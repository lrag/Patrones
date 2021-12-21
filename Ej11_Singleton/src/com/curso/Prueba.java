package com.curso;

import com.curso.modelo.negocio.GestorClientes;

public class Prueba {

	public static void main(String[] args) {
		
		//GestorClientes gc = new GestorClientes();
		
		GestorClientes gc1 = GestorClientes.getInstancia();
		GestorClientes gc2 = GestorClientes.getInstancia();
		GestorClientes gc3 = GestorClientes.getInstancia();
		GestorClientes gc4 = GestorClientes.getInstancia();
		
		System.out.println(gc1);
		System.out.println(gc2);
		System.out.println(gc3);
		System.out.println(gc4);
		
	}
	
}
