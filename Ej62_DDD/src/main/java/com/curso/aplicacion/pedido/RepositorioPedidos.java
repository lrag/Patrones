package com.curso.aplicacion.pedido;

import java.util.List;
import java.util.Optional;

import com.curso.dominio.entidad.cliente.ClienteId;
import com.curso.dominio.entidad.pedido.Pedido;
import com.curso.dominio.entidad.pedido.PedidoId;

public interface RepositorioPedidos {

    void guardar(Pedido pedido);

    Optional<Pedido> buscarPorId(PedidoId id);

    List<Pedido> buscarPorCliente(ClienteId clienteId);
}
