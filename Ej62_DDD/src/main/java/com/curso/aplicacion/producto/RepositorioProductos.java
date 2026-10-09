package com.curso.aplicacion.producto;

import com.curso.dominio.entidad.producto.Producto;
import com.curso.dominio.entidad.producto.ProductoId;
import java.util.Optional;

public interface RepositorioProductos {

    Optional<Producto> buscarPorId(ProductoId id);
}
