package com.curso.dominio.servicio.oferta;

import com.curso.dominio.entidad.factura.LineaFactura;
import com.curso.dominio.entidad.producto.ProductoId;

import java.util.List;
import java.util.Set;

// Por cada tres unidades de uno de los productos, una es gratis: con 3 unidades se regala 1,
// con 6 se regalan 2, y con 2 no se regala ninguna.
public final class OfertaTresPorDos implements Oferta {

    private static final int UNIDADES_POR_GRUPO = 3;

    private final Set<ProductoId> productos;

    public OfertaTresPorDos(Set<ProductoId> productos) {
        if (productos == null || productos.isEmpty()) {
            throw new IllegalArgumentException("la oferta necesita al menos un producto");
        }
        this.productos = Set.copyOf(productos);
    }

    @Override
    public List<LineaFactura> aplicar(List<LineaFactura> lineas) {
        return lineas.stream().map(this::aplicarALinea).toList();
    }

    private LineaFactura aplicarALinea(LineaFactura linea) {
        if (!productos.contains(linea.productoId())) {
            return linea;
        }
        int unidadesGratis = linea.cantidad().valor() / UNIDADES_POR_GRUPO;
        if (unidadesGratis == 0) {
            return linea;
        }
        return linea.conDescuentoAdicional(linea.precioUnitario().multiplicar(unidadesGratis));
    }
}
