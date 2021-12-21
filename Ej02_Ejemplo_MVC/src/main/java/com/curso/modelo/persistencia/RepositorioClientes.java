package com.curso.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.curso.modelo.entidad.Cliente;

//Al heredar de JPARepository se incluye implícitamente '@Repository
@Repository
public interface RepositorioClientes extends JpaRepository<Cliente, Integer> {
	
	List<Cliente> findByActivo(Boolean activo);
	
	//List<Cliente> findByCiudad(String ciudad);
	//List<Cliente> findByCiudadAndActivo(String ciudad, Boolean activo);
	
	@Query("select c from Cliente c where activo=:activo")
	List<Cliente> listarPorEstado(Boolean activo);
	
}
