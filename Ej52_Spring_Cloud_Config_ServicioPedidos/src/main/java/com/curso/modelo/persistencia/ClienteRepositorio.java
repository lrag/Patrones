package com.curso.modelo.persistencia;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.curso.modelo.entidad.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer>{
	public Optional<Cliente> findByLogin(String login);
}
