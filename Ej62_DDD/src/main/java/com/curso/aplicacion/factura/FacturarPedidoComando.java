package com.curso.aplicacion.factura;

// DTO de entrada: el id del pedido tal como llega, sin validar.
public record FacturarPedidoComando(String pedidoId) {
}
