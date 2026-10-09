package com.curso.dominio.entidad.producto;

import java.util.Objects;
import java.util.UUID;

public final class ProductoId {

    private final UUID valor;

    private ProductoId(UUID valor) {
        this.valor = valor;
    }

    public static ProductoId nuevo() {
        return new ProductoId(UUID.randomUUID());
    }

    public static ProductoId of(UUID valor) {
        if (valor == null) {
            throw new IllegalArgumentException("el id del producto no puede ser nulo");
        }
        return new ProductoId(valor);
    }

    public static ProductoId of(String valor) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("el id del producto no puede estar en blanco");
        }
        try {
            return new ProductoId(UUID.fromString(valor.strip()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("el id del producto no es un UUID válido: " + valor, e);
        }
    }

    public UUID valor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductoId otro)) return false;
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
