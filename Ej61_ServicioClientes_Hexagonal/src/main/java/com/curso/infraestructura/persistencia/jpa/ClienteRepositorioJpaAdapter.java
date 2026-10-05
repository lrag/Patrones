package com.curso.infraestructura.persistencia.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import com.curso.aplicacion.puerto.persistencia.ClienteRepositorio;
import com.curso.dominio.Cliente;

@Repository
//Esto es un adapter (que además implementa el patrón de programación adapter)
@ConditionalOnProperty(name = "clientes.persistencia", havingValue = "jpa", matchIfMissing = true)
class ClienteRepositorioJpaAdapter implements ClienteRepositorio {

	private final ClienteJpaRepository jpaRepo;

	ClienteRepositorioJpaAdapter(ClienteJpaRepository jpaRepo) {
		this.jpaRepo = jpaRepo;
	}

	@Override
	public Optional<Cliente> buscarPorLogin(String login) {
		return jpaRepo.findByLogin(login).map(ClienteEntityMapper::aDominio);
	}

	@Override
	public List<Cliente> listar() {
		return jpaRepo.findAll().stream().map(ClienteEntityMapper::aDominio).toList();
	}

	@Override
	public Cliente guardar(Cliente cliente) {
		return ClienteEntityMapper.aDominio(jpaRepo.save(ClienteEntityMapper.aEntidad(cliente)));
	}

	@Override
	public void borrarPorLogin(String login) {
		jpaRepo.deleteByLogin(login);
	}

	@Override
	public long contar() {
		return jpaRepo.count();
	}

}
