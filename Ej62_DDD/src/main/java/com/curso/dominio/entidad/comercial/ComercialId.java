package com.curso.dominio.entidad.comercial;

import java.util.Objects;
import java.util.UUID;

public final class ComercialId {

    private final UUID valor;

    private ComercialId(UUID valor) {
        this.valor = valor;
    }

    public static ComercialId nuevo() {
        return new ComercialId(UUID.randomUUID());
    }

    public static ComercialId of(UUID valor) {
        if (valor == null) {
            throw new IllegalArgumentException("el id del comercial no puede ser nulo");
        }
        return new ComercialId(valor);
    }

    public static ComercialId of(String valor) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("el id del comercial no puede estar en blanco");
        }
        try {
            return new ComercialId(UUID.fromString(valor.strip()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("el id del comercial no es un UUID válido: " + valor, e);
        }
    }

    public UUID valor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComercialId otro)) return false;
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
