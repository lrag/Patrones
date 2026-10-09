package com.curso.aplicacion.factura;

import com.curso.aplicacion.pedido.PedidoNoEncontradoException;
import com.curso.aplicacion.pedido.RepositorioPedidos;
import com.curso.dominio.entidad.factura.Factura;
import com.curso.dominio.entidad.factura.FacturaId;
import com.curso.dominio.entidad.pedido.Pedido;
import com.curso.dominio.entidad.pedido.PedidoId;
import com.curso.dominio.servicio.Facturador;
import com.curso.dominio.servicio.oferta.Oferta;
import com.curso.dominio.servicio.oferta.SinOferta;

// Servicio de aplicación del caso de uso "facturar un pedido": carga el pedido, se asegura de que no se
// facture dos veces (algo que ni el pedido ni la factura pueden saber) y delega en el servicio de dominio
// la conversión del pedido en factura. Después guarda la factura.
public class FacturarPedido {

    private final RepositorioPedidos pedidos;
    private final RepositorioFacturas facturas;
    private final Facturador facturador;

    public FacturarPedido(RepositorioPedidos pedidos, RepositorioFacturas facturas, Facturador facturador) {
        this.pedidos = pedidos;
        this.facturas = facturas;
        this.facturador = facturador;
    }

    public FacturaId ejecutar(FacturarPedidoComando comando) {
        if (comando == null) {
            throw new IllegalArgumentException("el comando no puede ser nulo");
        }

        // Del DTO al Value Object: aquí se valida el id recibido.
        PedidoId pedidoId = PedidoId.of(comando.pedidoId());

        Pedido pedido = pedidos.buscarPorId(pedidoId).orElseThrow(() -> new PedidoNoEncontradoException(pedidoId));

        // Regla entre agregados: un pedido se factura una sola vez.
        if (facturas.existePorPedido(pedidoId)) {
            throw new PedidoYaFacturadoException(pedidoId);
        }

        //Por simplificar
        Oferta oferta = new SinOferta();

        Factura factura = facturador.facturar(pedido, oferta);
        facturas.guardar(factura);
        return factura.id();
    }
}
