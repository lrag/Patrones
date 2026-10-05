package com.curso.infraestructura.persistencia.mongodb;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.dominio.Cliente;

interface ClienteMongoDBRepository /*extends MongoDBRepository<ClienteMongoDB, Integer>*/ {

	Optional<ClienteMongoDB> findByLogin(String login);
	void deleteByLogin(String login);
	
	//Fingiendo que es un MongoDBRepo...
	long count();
	Optional<ClienteMongoDB> findAll();
	ClienteMongoDB save(ClienteMongoDB aEntidad);

}
