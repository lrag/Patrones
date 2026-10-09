package com.curso.aplicacion.cliente;

import com.curso.dominio.entidad.cliente.ClienteId;

public class ClienteNoEncontradoException extends RuntimeException {

    public ClienteNoEncontradoException(ClienteId id) {
        super("no existe el cliente " + id);
    }
}
