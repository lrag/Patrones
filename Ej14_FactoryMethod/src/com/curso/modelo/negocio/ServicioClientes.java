package com.curso.modelo.negocio;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.persistencia.ClienteRepositorio;
import com.curso.modelo.persistencia.util.FactoriaClienteRepositorio;

public class ServicioClientes {
	
	//SINGLETÓN/////////////////////////////////////////////////////////	
	
	private static ServicioClientes instancia;

	public static synchronized ServicioClientes getInstancia() {
		if(instancia == null) {
			instancia = new ServicioClientes();
		}
		return instancia;
	}

	private ServicioClientes(){
	}
	
	////////////////////////////////////////////////////////////////////
	
	private ClienteRepositorio clienteRepo = FactoriaClienteRepositorio.getClienteRepositorio();
	
	public void insertar(Cliente cliente) {
		System.out.println("=====================================");
		System.out.println("Insertando en GestorClientes");
		System.out.println("Cliente:"+cliente);
		//LN...
		clienteRepo.insertar(cliente);
	}	
	
}
