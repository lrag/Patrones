package com.curso.aplicacion.pedido;

import com.curso.dominio.entidad.pedido.PedidoId;

public class PedidoNoEncontradoException extends RuntimeException {

    public PedidoNoEncontradoException(PedidoId id) {
        super("no existe el pedido " + id);
    }
}
