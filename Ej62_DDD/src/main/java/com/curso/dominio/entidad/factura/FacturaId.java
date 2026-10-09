package com.curso.dominio.entidad.factura;

import java.util.Objects;
import java.util.UUID;

public final class FacturaId {

    private final UUID valor;

    private FacturaId(UUID valor) {
        this.valor = valor;
    }

    public static FacturaId nuevo() {
        return new FacturaId(UUID.randomUUID());
    }

    public static FacturaId of(UUID valor) {
        if (valor == null) {
            throw new IllegalArgumentException("el id de la factura no puede ser nulo");
        }
        return new FacturaId(valor);
    }

    public static FacturaId of(String valor) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("el id de la factura no puede estar en blanco");
        }
        try {
            return new FacturaId(UUID.fromString(valor.strip()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("el id de la factura no es un UUID válido: " + valor, e);
        }
    }

    public UUID valor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FacturaId otro)) return false;
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
