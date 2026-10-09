package com.curso.aplicacion.review;

import com.curso.dominio.entidad.cliente.ClienteId;
import com.curso.dominio.entidad.producto.ProductoId;

public class ReviewNoPermitidaException extends RuntimeException {

    public ReviewNoPermitidaException(ClienteId clienteId, ProductoId productoId) {
        super("el cliente " + clienteId + " no puede hacer una review del producto " + productoId);
    }
}
