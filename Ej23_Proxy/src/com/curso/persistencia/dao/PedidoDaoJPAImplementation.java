package com.curso.persistencia.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.curso.modelo.entidad.Pedido;

public class PedidoDaoJPAImplementation extends AbstractJPADao<Pedido, Integer> implements PedidoDao{

	private EntityManager em;

	@Override
	public Pedido buscarConDetalles(Integer id) {
		TypedQuery<Pedido> q = em.createQuery("select p from Pedido p where p.id=:id", Pedido.class);
		q.setParameter("id", id);
		q.setHint("javax.persistence.loadgraph", em.getEntityGraph("PedidoConDetalles"));
		
		return q.getResultList().stream().findFirst().orElse(null);
	}

}












