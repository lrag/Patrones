package com.curso.persistencia.transacciones;

import javax.persistence.EntityManager;

class DatosTransaccion {

	EntityManager em;
	Integer contador;

	public DatosTransaccion(EntityManager em, Integer contador) {
		super();
		this.em = em;
		this.contador = contador;
	}

}
