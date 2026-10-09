package com.curso.aplicacion.cliente;

import com.curso.dominio.entidad.cliente.Cliente;
import com.curso.dominio.entidad.cliente.ClienteId;
import com.curso.dominio.vo.CorreoElectronico;
import java.util.Optional;

// Contrato que necesitan los casos de uso para guardar y recuperar clientes.
// Lo implementa la infraestructura (una base de datos, una versión en memoria...); el dominio no lo conoce.
public interface RepositorioClientes {

    void guardar(Cliente cliente);

    Optional<Cliente> buscarPorId(ClienteId id);

    boolean existePorCorreo(CorreoElectronico correo);
}
