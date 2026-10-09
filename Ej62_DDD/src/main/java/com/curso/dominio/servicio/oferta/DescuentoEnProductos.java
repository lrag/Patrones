package com.curso.dominio.servicio.oferta;

import com.curso.dominio.entidad.factura.LineaFactura;
import com.curso.dominio.entidad.producto.ProductoId;
import com.curso.dominio.vo.Porcentaje;
import java.util.List;
import java.util.Set;

// Un porcentaje de descuento solo sobre las líneas de unos productos concretos.
public final class DescuentoEnProductos implements Oferta {

    private final Set<ProductoId> productos;
    private final Porcentaje porcentaje;

    public DescuentoEnProductos(Set<ProductoId> productos, Porcentaje porcentaje) {
        if (productos == null || productos.isEmpty()) {
            throw new IllegalArgumentException("la oferta necesita al menos un producto");
        }
        if (porcentaje == null) {
            throw new IllegalArgumentException("el porcentaje no puede ser nulo");
        }
        this.productos = Set.copyOf(productos);
        this.porcentaje = porcentaje;
    }

    @Override
    public List<LineaFactura> aplicar(List<LineaFactura> lineas) {
        return lineas.stream()
                .map(linea -> productos.contains(linea.productoId())
                        ? linea.conDescuentoAdicional(porcentaje.aplicarA(linea.importeNeto()))
                        : linea)
                .toList();
    }
}
