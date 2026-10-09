package com.curso.aplicacion.factura;

import com.curso.dominio.entidad.factura.Factura;
import com.curso.dominio.entidad.factura.FacturaId;
import com.curso.dominio.entidad.pedido.PedidoId;
import java.util.Optional;

public interface RepositorioFacturas {

    void guardar(Factura factura);

    Optional<Factura> buscarPorId(FacturaId id);

    boolean existePorPedido(PedidoId pedidoId);
}
