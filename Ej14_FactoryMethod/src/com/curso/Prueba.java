package com.curso;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.negocio.GestorClientes;

public class Prueba {

	public static void main(String[] args) {
		
		Cliente c = new Cliente(1,"Bart","C/Evergreen Terrace","555");
		
		GestorClientes gc = GestorClientes.getInstancia();
		gc.insertar(c);		
		
	}
	
}
