package com.curso.aplicacion.factura;

import com.curso.dominio.entidad.pedido.PedidoId;

public class PedidoYaFacturadoException extends RuntimeException {

    public PedidoYaFacturadoException(PedidoId pedidoId) {
        super("el pedido " + pedidoId + " ya está facturado");
    }
}
