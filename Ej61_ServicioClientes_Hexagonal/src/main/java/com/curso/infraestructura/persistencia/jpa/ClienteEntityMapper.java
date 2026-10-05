package com.curso.infraestructura.persistencia.jpa;

import com.curso.dominio.Cliente;

final class ClienteEntityMapper {

	private ClienteEntityMapper() {
	}

	static Cliente aDominio(ClienteEntity e) {
		return new Cliente(e.getId(), e.getLogin(), e.getNombre(), e.getDireccion(), e.getTelefono(),
				e.getCorreoE(), e.getDatosBancarios());
	}

	static ClienteEntity aEntidad(Cliente c) {
		ClienteEntity e = new ClienteEntity();
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
