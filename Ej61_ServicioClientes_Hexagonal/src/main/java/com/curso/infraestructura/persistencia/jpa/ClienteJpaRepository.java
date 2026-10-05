package com.curso.infraestructura.persistencia.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

interface ClienteJpaRepository extends JpaRepository<ClienteEntity, Integer> {

	Optional<ClienteEntity> findByLogin(String login);
	void deleteByLogin(String login);

}
