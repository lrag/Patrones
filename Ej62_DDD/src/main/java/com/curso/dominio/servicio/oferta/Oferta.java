package com.curso.dominio.servicio.oferta;

import java.util.List;

import com.curso.dominio.entidad.factura.LineaFactura;

// Estrategia: cada oferta transforma las líneas de una factura (ajusta descuentos, añade líneas, o las deja igual).
// Es una función pura: devuelve una lista nueva y no modifica nada, ni las líneas ni el pedido.
// Al tener un único método, también puede escribirse como lambda.
@FunctionalInterface
public interface Oferta {

    List<LineaFactura> aplicar(List<LineaFactura> lineas);
}
