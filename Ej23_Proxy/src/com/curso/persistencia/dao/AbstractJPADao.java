package com.curso.persistencia.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.curso.persistencia.transacciones.EntityManager_PROXY;

public abstract class AbstractJPADao<T, K> implements InterfaceDao<T, K>{

	//Este proxy podría ser un singleton
	protected EntityManager em = new EntityManager_PROXY();
	
	@SuppressWarnings("unchecked")
	private Class<T> clase = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	
	@Override
	public void insertar(T obj) {
		em.persist(obj);
	}	
	
	@Override
	public void modificar(T obj) {
		em.merge(obj);
	}

	@Override
	public void borrar(T obj) {
		obj = em.merge(obj);
		em.remove(obj);
	}
	
	@Override
	public T buscar(K id) {
		return (T) em.find(clase, id);
	}
	
	@Override
	public List<T> listar() {
		TypedQuery<T> q = em.createQuery("select o from "+clase.getName()+" o",clase);
		return q.getResultList();
	}	
	
}


