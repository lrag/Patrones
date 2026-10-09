package com.curso.dominio.entidad.sucursal;

import java.util.Objects;
import java.util.UUID;

public final class SucursalId {

    private final UUID valor;

    private SucursalId(UUID valor) {
        this.valor = valor;
    }

    public static SucursalId nuevo() {
        return new SucursalId(UUID.randomUUID());
    }

    public static SucursalId of(UUID valor) {
        if (valor == null) {
            throw new IllegalArgumentException("el id de la sucursal no puede ser nulo");
        }
        return new SucursalId(valor);
    }

    public static SucursalId of(String valor) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("el id de la sucursal no puede estar en blanco");
        }
        try {
            return new SucursalId(UUID.fromString(valor.strip()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("el id de la sucursal no es un UUID válido: " + valor, e);
        }
    }

    public UUID valor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SucursalId otro)) return false;
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
