package com.curso.aplicacion.pedido;

import java.util.List;

// DTO de entrada: los datos tal como llegan, sin validar. La moneda es el código ISO ("EUR").
public record CrearPedidoComando(String clienteId, String moneda, List<Linea> lineas) {

    public record Linea(String productoId, int cantidad) {
    }
}
