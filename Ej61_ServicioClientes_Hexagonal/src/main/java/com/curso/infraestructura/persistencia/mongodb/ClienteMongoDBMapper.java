package com.curso.infraestructura.persistencia.mongodb;

import com.curso.dominio.Cliente;

final class ClienteMongoDBMapper {

	private ClienteMongoDBMapper() {
	}

	static Cliente aDominio(ClienteMongoDB e) {
		return new Cliente(e.getId(), e.getLogin(), e.getNombre(), e.getDireccion(), e.getTelefono(),
				e.getCorreoE(), e.getDatosBancarios());
	}

	static ClienteMongoDB aEntidad(Cliente c) {
		ClienteMongoDB e = new ClienteMongoDB();
		e.setId(c.getId());
		e.setLogin(c.getLogin());
		e.setNombre(c.getNombre());
		e.setDireccion(c.getDireccion());
		e.setTelefono(c.getTelefono());
		e.setCorreoE(c.getCorreoE());
		e.setDatosBancarios(c.getDatosBancarios());
		return e;
	}

}
