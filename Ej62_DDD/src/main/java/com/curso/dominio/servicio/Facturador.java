package com.curso.dominio.servicio;

import com.curso.dominio.entidad.factura.Factura;
import com.curso.dominio.entidad.factura.LineaFactura;
import com.curso.dominio.entidad.pedido.EstadoPedido;
import com.curso.dominio.entidad.pedido.Pedido;
import com.curso.dominio.servicio.oferta.Oferta;
import java.time.Clock;
import java.time.LocalDate;
import java.util.List;

// Servicio de dominio: convierte un Pedido en una Factura aplicando una oferta.
// No modifica el pedido, no guarda nada ni consulta repositorios: devuelve la factura y quien lo usa
// (un servicio de aplicación) la guarda y se asegura de que el pedido no se facture dos veces.
// La fecha de emisión es la del reloj del sistema; el reloj se puede inyectar para poder probarlo.
public class Facturador {

    private final Clock reloj;

    public Facturador() {
        this(Clock.systemDefaultZone());
    }

    public Facturador(Clock reloj) {
        if (reloj == null) {
            throw new IllegalArgumentException("el reloj no puede ser nulo");
        }
        this.reloj = reloj;
    }

    public Factura facturar(Pedido pedido, Oferta oferta) {
        if (pedido == null) {
            throw new IllegalArgumentException("el pedido no puede ser nulo");
        }
        if (oferta == null) {
            throw new IllegalArgumentException("la oferta no puede ser nula");
        }
        if (pedido.estado() != EstadoPedido.PAGADO) {
            throw new IllegalStateException("solo se pueden facturar pedidos pagados, y este está " + pedido.estado());
        }
        List<LineaFactura> lineasConOferta = oferta.aplicar(lineasSinDescuento(pedido));
        if (lineasConOferta == null) {
            throw new IllegalStateException("la oferta no ha devuelto líneas");
        }
        Factura factura = Factura.emitir(pedido.id(), pedido.clienteId(), LocalDate.now(reloj), lineasConOferta);
        // Una oferta solo puede rebajar lo que paga el cliente, nunca aumentarlo.
        if (factura.total().esMayorQue(pedido.total())) {
            throw new IllegalStateException("la oferta no puede aumentar el importe del pedido");
        }
        return factura;
    }

    private List<LineaFactura> lineasSinDescuento(Pedido pedido) {
        return pedido.detalles().stream()
                .map(detalle -> LineaFactura.of(detalle.productoId(), detalle.nombreProducto(), detalle.cantidad(),
                        detalle.precioUnitario()))
                .toList();
    }
}
