package com.curso.infraestructura.persistencia.mongodb;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import com.curso.aplicacion.puerto.persistencia.ClienteRepositorio;
import com.curso.dominio.Cliente;

@Repository
//Esto es un adapter de Hexagonal y un adapter del patrón de programación :D
@ConditionalOnProperty(name = "clientes.persistencia", havingValue = "mongodb")
class ClienteRepositorioMongoDBAdapter implements ClienteRepositorio {

	private final ClienteMongoDBRepository mongoDBRepo;

	ClienteRepositorioMongoDBAdapter(ClienteMongoDBRepository mongoRepo) {
		this.mongoDBRepo = mongoRepo;
	}

	@Override
	public Optional<Cliente> buscarPorLogin(String login) {
		return mongoDBRepo.findByLogin(login).map(ClienteMongoDBMapper::aDominio);
	}

	@Override
	public List<Cliente> listar() {
		return mongoDBRepo.findAll().stream().map(ClienteMongoDBMapper::aDominio).toList();
	}

	@Override
	public Cliente guardar(Cliente cliente) {
		return ClienteMongoDBMapper.aDominio(mongoDBRepo.save(ClienteMongoDBMapper.aEntidad(cliente)));
	}

	@Override
	public void borrarPorLogin(String login) {
		mongoDBRepo.deleteByLogin(login);
	}

	@Override
	public long contar() {
		return mongoDBRepo.count();
	}

}
