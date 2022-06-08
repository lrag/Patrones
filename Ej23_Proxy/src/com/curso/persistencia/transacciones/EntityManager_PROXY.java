package com.curso.persistencia.transacciones;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;

public class EntityManager_PROXY implements EntityManager {

	//SINGLETÓN////////////////////////////////////////////////
	private static EntityManager_PROXY instancia;
	
	public static synchronized EntityManager getInstancia() {
		if(instancia == null) {
			instancia = new EntityManager_PROXY();
		}
		return instancia;
	}	
	///////////////////////////////////////////////////////////
	
	private EntityManager_PROXY() {
	}
	
	@Override
	public void persist(Object entity) {
		GestorTransacciones.getEntityManager().persist(entity);
	}

	@Override
	public <T> T merge(T entity) {
		return GestorTransacciones.getEntityManager().merge(entity);
	}

	@Override
	public void remove(Object entity) {
		GestorTransacciones.getEntityManager().remove(entity);
	}

	@Override
	public <T> T find(Class<T> entityClass, Object primaryKey) {
		return GestorTransacciones.getEntityManager().find(entityClass, primaryKey);
	}

	@Override
	public <T> T find(Class<T> entityClass, Object primaryKey, Map<String, Object> properties) {
		return GestorTransacciones.getEntityManager().find(entityClass, primaryKey, properties);
	}

	@Override
	public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode) {
		return GestorTransacciones.getEntityManager().find(entityClass, primaryKey, lockMode);
	}

	@Override
	public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode, Map<String, Object> properties) {
		return GestorTransacciones.getEntityManager().find(entityClass, primaryKey, lockMode, properties);
	}

	@Override
	public <T> T getReference(Class<T> entityClass, Object primaryKey) {
		return GestorTransacciones.getEntityManager().getReference(entityClass, primaryKey);
	}

	@Override
	public void flush() {
		GestorTransacciones.getEntityManager().flush();
	}

	@Override
	public void setFlushMode(FlushModeType flushMode) {
		GestorTransacciones.getEntityManager().setFlushMode(flushMode);
	}

	@Override
	public FlushModeType getFlushMode() {
		return GestorTransacciones.getEntityManager().getFlushMode();
	}

	@Override
	public void lock(Object entity, LockModeType lockMode) {
		GestorTransacciones.getEntityManager().lock(entity, lockMode);
	}

	@Override
	public void lock(Object entity, LockModeType lockMode, Map<String, Object> properties) {
		GestorTransacciones.getEntityManager().lock(entity, lockMode, properties);
	}

	@Override
	public void refresh(Object entity) {
		GestorTransacciones.getEntityManager().refresh(entity);
	}

	@Override
	public void refresh(Object entity, Map<String, Object> properties) {
		GestorTransacciones.getEntityManager().refresh(entity, properties);
	}

	@Override
	public void refresh(Object entity, LockModeType lockMode) {
		GestorTransacciones.getEntityManager().refresh(entity, lockMode);
	}

	@Override
	public void refresh(Object entity, LockModeType lockMode, Map<String, Object> properties) {
		GestorTransacciones.getEntityManager().refresh(entity, lockMode, properties);
	}

	@Override
	public void clear() {
		GestorTransacciones.getEntityManager().clear();
	}

	@Override
	public void detach(Object entity) {
		GestorTransacciones.getEntityManager().detach(entity);
	}

	@Override
	public boolean contains(Object entity) {
		return GestorTransacciones.getEntityManager().contains(entity);
	}

	@Override
	public LockModeType getLockMode(Object entity) {
		return GestorTransacciones.getEntityManager().getLockMode(entity);
	}

	@Override
	public void setProperty(String propertyName, Object value) {
		GestorTransacciones.getEntityManager().setProperty(propertyName, value);
	}

	@Override
	public Map<String, Object> getProperties() {
		return GestorTransacciones.getEntityManager().getProperties();
	}

	@Override
	public Query createQuery(String qlString) {
		return GestorTransacciones.getEntityManager().createQuery(qlString);
	}

	@Override
	public <T> TypedQuery<T> createQuery(CriteriaQuery<T> criteriaQuery) {
		return GestorTransacciones.getEntityManager().createQuery(criteriaQuery);
	}

	@Override
	public Query createQuery(CriteriaUpdate updateQuery) {
		return GestorTransacciones.getEntityManager().createQuery(updateQuery);
	}

	@Override
	public Query createQuery(CriteriaDelete deleteQuery) {
		return GestorTransacciones.getEntityManager().createQuery(deleteQuery);
	}

	@Override
	public <T> TypedQuery<T> createQuery(String qlString, Class<T> resultClass) {
		return GestorTransacciones.getEntityManager().createQuery(qlString, resultClass);
	}

	@Override
	public Query createNamedQuery(String name) {
		return GestorTransacciones.getEntityManager().createNamedQuery(name);
	}

	@Override
	public <T> TypedQuery<T> createNamedQuery(String name, Class<T> resultClass) {
		return GestorTransacciones.getEntityManager().createNamedQuery(name, resultClass);
	}

	@Override
	public Query createNativeQuery(String sqlString) {
		return GestorTransacciones.getEntityManager().createNativeQuery(sqlString);
	}

	@Override
	public Query createNativeQuery(String sqlString, Class resultClass) {
		return GestorTransacciones.getEntityManager().createNativeQuery(sqlString, resultClass);
	}

	@Override
	public Query createNativeQuery(String sqlString, String resultSetMapping) {
		return GestorTransacciones.getEntityManager().createNativeQuery(sqlString, resultSetMapping);
	}

	@Override
	public StoredProcedureQuery createNamedStoredProcedureQuery(String name) {
		return GestorTransacciones.getEntityManager().createNamedStoredProcedureQuery(name);
	}

	@Override
	public StoredProcedureQuery createStoredProcedureQuery(String procedureName) {
		return GestorTransacciones.getEntityManager().createStoredProcedureQuery(procedureName);
	}

	@Override
	public StoredProcedureQuery createStoredProcedureQuery(String procedureName, Class... resultClasses) {
		return GestorTransacciones.getEntityManager().createStoredProcedureQuery(procedureName, resultClasses);
	}

	@Override
	public StoredProcedureQuery createStoredProcedureQuery(String procedureName, String... resultSetMappings) {
		return GestorTransacciones.getEntityManager().createStoredProcedureQuery(procedureName, resultSetMappings);
	}

	@Override
	public void joinTransaction() {
		GestorTransacciones.getEntityManager().joinTransaction();
	}

	@Override
	public boolean isJoinedToTransaction() {
		return GestorTransacciones.getEntityManager().isJoinedToTransaction();
	}

	@Override
	public <T> T unwrap(Class<T> cls) {
		return GestorTransacciones.getEntityManager().unwrap(cls);
	}

	@Override
	public Object getDelegate() {
		return GestorTransacciones.getEntityManager().getDelegate();
	}

	@Override
	public void close() {
		GestorTransacciones.getEntityManager().close();
	}

	@Override
	public boolean isOpen() {
		return GestorTransacciones.getEntityManager().isOpen();
	}

	@Override
	public EntityTransaction getTransaction() {
		return GestorTransacciones.getEntityManager().getTransaction();
	}

	@Override
	public EntityManagerFactory getEntityManagerFactory() {
		return GestorTransacciones.getEntityManager().getEntityManagerFactory();
	}

	@Override
	public CriteriaBuilder getCriteriaBuilder() {
		return GestorTransacciones.getEntityManager().getCriteriaBuilder();
	}

	@Override
	public Metamodel getMetamodel() {
		return GestorTransacciones.getEntityManager().getMetamodel();
	}

	@Override
	public <T> EntityGraph<T> createEntityGraph(Class<T> rootType) {
		return GestorTransacciones.getEntityManager().createEntityGraph(rootType);
	}

	@Override
	public EntityGraph<?> createEntityGraph(String graphName) {
		return GestorTransacciones.getEntityManager().createEntityGraph(graphName);
	}

	@Override
	public EntityGraph<?> getEntityGraph(String graphName) {
		return GestorTransacciones.getEntityManager().getEntityGraph(graphName);
	}

	@Override
	public <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> entityClass) {
		return GestorTransacciones.getEntityManager().getEntityGraphs(entityClass);
	}

}
