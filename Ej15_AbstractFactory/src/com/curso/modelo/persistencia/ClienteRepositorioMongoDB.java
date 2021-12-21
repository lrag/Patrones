package com.curso.modelo.persistencia;

import com.curso.modelo.entidad.Cliente;

public class ClienteRepositorioMongoDB implements ClienteRepositorio {

	private static ClienteRepositorio instancia;
	
	public static synchronized ClienteRepositorio getInstancia() {
		if(instancia == null) {
			instancia = new ClienteRepositorioMongoDB();
		}
		return instancia;
	}

	private ClienteRepositorioMongoDB() {
	}

	@Override
	public void insertar(Cliente cliente) {
		System.out.println("=====================================");
		System.out.println("Insertando en MongoDB");
		System.out.println("Cliente:"+cliente);
	}
	
}
