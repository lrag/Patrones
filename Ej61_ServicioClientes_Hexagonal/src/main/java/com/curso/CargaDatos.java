package com.curso;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.curso.aplicacion.puerto.persistencia.ClienteRepositorio;
import com.curso.dominio.Cliente;

@Component
class CargaDatos implements CommandLineRunner {

	private final ClienteRepositorio clienteRepo;

	CargaDatos(ClienteRepositorio clienteRepo) {
		this.clienteRepo = clienteRepo;
	}

	@Override
	public void run(String... args) {
		System.out.println("=============================");
		if(clienteRepo.contar() == 0) {
			clienteRepo.guardar(new Cliente(null,"lew","Lew Archer","C/Tal,123","555","lew@archer.com","banco 1"));
			clienteRepo.guardar(new Cliente(null,"philip","Philip Marlowe","C/Pascual,123","555","philip@marlowe.com","banco 2"));
			clienteRepo.guardar(new Cliente(null,"sam","Sam Spade","C/Tal y Pascual,123","555","sam@spade.com","banco 3"));
			clienteRepo.guardar(new Cliente(null,"jesus","Jesus Witness","C/Falsa,123","555","jotero@greatfarandulaindustries.es","banco 4"));
			clienteRepo.guardar(new Cliente(null,"agente","El agente de la Continental","C/Pascualillo,123","555","agente@continental.com","banco 5"));
		}
	}

}
