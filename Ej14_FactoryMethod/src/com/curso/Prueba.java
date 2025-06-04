package com.curso;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.negocio.ServicioClientes;

public class Prueba {

	public static void main(String[] args) {
		
		Cliente c = new Cliente(1,"Bart","C/Evergreen Terrace","555");
		
		ServicioClientes gc = ServicioClientes.getInstancia();
		gc.insertar(c);		
		
	}
	
}
