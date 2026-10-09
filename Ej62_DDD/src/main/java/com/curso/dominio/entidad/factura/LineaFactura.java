package com.curso.dominio.entidad.factura;

import com.curso.dominio.entidad.producto.Cantidad;
import com.curso.dominio.entidad.producto.ProductoId;
import com.curso.dominio.vo.Dinero;
import java.util.Objects;

// Value Object y no entidad: una línea de una factura ya emitida no cambia nunca, no tiene ciclo de vida
// y solo se distingue por lo que dice. El descuento es el importe que se rebaja de esta línea
// (un porcentaje, unidades gratis, un regalo...), ya calculado.
public final class LineaFactura {

    private final ProductoId productoId;
    private final String descripcion;
    private final Cantidad cantidad;
    private final Dinero precioUnitario;
    private final Dinero descuento;

    private LineaFactura(ProductoId productoId, String descripcion, Cantidad cantidad, Dinero precioUnitario,
                         Dinero descuento) {
        this.productoId = productoId;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.descuento = descuento;
    }

    public static LineaFactura of(ProductoId productoId, String descripcion, Cantidad cantidad,
                                  Dinero precioUnitario, Dinero descuento) {
        if (productoId == null) {
            throw new IllegalArgumentException("el producto de la línea no puede ser nulo");
        }
        if (descripcion == null || descripcion.isBlank()) {
            throw new IllegalArgumentException("la descripción de la línea no puede estar en blanco");
        }
        if (cantidad == null) {
            throw new IllegalArgumentException("la cantidad de la línea no puede ser nula");
        }
        if (precioUnitario == null) {
            throw new IllegalArgumentException("el precio unitario de la línea no puede ser nulo");
        }
        if (descuento == null) {
            throw new IllegalArgumentException("el descuento de la línea no puede ser nulo");
        }
        if (precioUnitario.esNegativo()) {
            throw new IllegalArgumentException("el precio unitario no puede ser negativo: " + precioUnitario);
        }
        if (descuento.esNegativo()) {
            throw new IllegalArgumentException("el descuento no puede ser negativo: " + descuento);
        }
        if (!descuento.moneda().equals(precioUnitario.moneda())) {
            throw new IllegalArgumentException("el descuento y el precio deben estar en la misma moneda");
        }
        if (descuento.esMayorQue(precioUnitario.multiplicar(cantidad.valor()))) {
            throw new IllegalArgumentException("el descuento " + descuento + " supera el importe de la línea");
        }
        return new LineaFactura(productoId, descripcion.strip(), cantidad, precioUnitario, descuento);
    }

    public static LineaFactura of(ProductoId productoId, String descripcion, Cantidad cantidad,
                                  Dinero precioUnitario) {
        if (precioUnitario == null) {
            throw new IllegalArgumentException("el precio unitario de la línea no puede ser nulo");
        }
        return of(productoId, descripcion, cantidad, precioUnitario, Dinero.cero(precioUnitario.moneda()));
    }

    // Devuelve una línea igual con un descuento mayor; la original no cambia.
    public LineaFactura conDescuentoAdicional(Dinero adicional) {
        if (adicional == null) {
            throw new IllegalArgumentException("el descuento adicional no puede ser nulo");
        }
        return of(productoId, descripcion, cantidad, precioUnitario, descuento.sumar(adicional));
    }

    // Importe antes de descuentos: precio unitario por cantidad.
    public Dinero importeBruto() {
        return precioUnitario.multiplicar(cantidad.valor());
    }

    public Dinero importeNeto() {
        return importeBruto().restar(descuento);
    }

    public ProductoId productoId() {
        return productoId;
    }

    public String descripcion() {
        return descripcion;
    }

    public Cantidad cantidad() {
        return cantidad;
    }

    public Dinero precioUnitario() {
        return precioUnitario;
    }

    public Dinero descuento() {
        return descuento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LineaFactura otra)) return false;
        return productoId.equals(otra.productoId)
                && descripcion.equals(otra.descripcion)
                && cantidad.equals(otra.cantidad)
                && precioUnitario.equals(otra.precioUnitario)
                && descuento.equals(otra.descuento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productoId, descripcion, cantidad, precioUnitario, descuento);
    }

    @Override
    public String toString() {
        return cantidad + " x " + descripcion + " (" + precioUnitario + ", descuento " + descuento + ")";
    }
}
