package com.curso.modelo.negocio;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.persistencia.ClienteRepositorio;
import com.curso.persistencia.util.FactoriaClienteRepositorio;

public class GestorClientes {
	
	private static GestorClientes instancia;

	public static synchronized GestorClientes getInstancia() {
		if(instancia == null) {
			instancia = new GestorClientes();
		}
		return instancia;
	}
	
	private ClienteRepositorio clienteRepo = FactoriaClienteRepositorio.getClienteRepositorio();
	
	public void insertar(Cliente cliente) {
		System.out.println("=====================================");
		System.out.println("Insertando en GestorClientes");
		System.out.println("Cliente:"+cliente);
		//LN...
		clienteRepo.insertar(cliente);
	}
	
	
}
