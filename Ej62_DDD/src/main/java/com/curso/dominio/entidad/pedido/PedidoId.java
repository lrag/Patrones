package com.curso.dominio.entidad.pedido;

import java.util.Objects;
import java.util.UUID;

public final class PedidoId {

    private final UUID valor;

    private PedidoId(UUID valor) {
        this.valor = valor;
    }

    public static PedidoId nuevo() {
        return new PedidoId(UUID.randomUUID());
    }

    public static PedidoId of(UUID valor) {
        if (valor == null) {
            throw new IllegalArgumentException("el id del pedido no puede ser nulo");
        }
        return new PedidoId(valor);
    }

    public static PedidoId of(String valor) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("el id del pedido no puede estar en blanco");
        }
        try {
            return new PedidoId(UUID.fromString(valor.strip()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("el id del pedido no es un UUID válido: " + valor, e);
        }
    }

    public UUID valor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PedidoId otro)) return false;
        return valor.equals(otro.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String toString() {
        return valor.toString();
    }
}
