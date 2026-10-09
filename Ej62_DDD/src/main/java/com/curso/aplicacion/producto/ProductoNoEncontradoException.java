package com.curso.aplicacion.producto;

import com.curso.dominio.entidad.producto.ProductoId;

public class ProductoNoEncontradoException extends RuntimeException {

    public ProductoNoEncontradoException(ProductoId id) {
        super("no existe el producto " + id);
    }
}
