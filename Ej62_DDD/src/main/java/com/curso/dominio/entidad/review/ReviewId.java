package com.curso.dominio.entidad.review;

import java.util.Objects;
import java.util.UUID;

public final class ReviewId {

    private final UUID valor;

    private ReviewId(UUID valor) {
        this.valor = valor;
    }

    public static ReviewId nuevo() {
        return new ReviewId(UUID.randomUUID());
    }

    public static ReviewId of(UUID valor) {
        if (valor == null) {
            throw new IllegalArgumentException("el id de la review no puede ser nulo");
        }
        return new ReviewId(valor);
    }

    public static ReviewId of(String valor) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("el id de la review no puede estar en blanco");
        }
        try {
            return new ReviewId(UUID.fromString(valor.strip()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("el id de la review no es un UUID válido: " + valor, e);
        }
    }

    public UUID valor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReviewId otro)) return false;
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
