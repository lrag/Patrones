package com.curso.dominio.vo;

import java.util.Objects;

public final class Nombre {

    private static final int LONGITUD_MAXIMA = 100;

    private final String valor;

    private Nombre(String valor) {
        this.valor = valor;
    }

    // Quita los espacios de los extremos y colapsa los repetidos: " Ana   María " pasa a "Ana María".
    public static Nombre of(String valor) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("el nombre no puede estar en blanco");
        }
        String normalizado = valor.strip().replaceAll("\\s+", " ");
        if (normalizado.length() > LONGITUD_MAXIMA) {
            throw new IllegalArgumentException("el nombre no puede superar " + LONGITUD_MAXIMA + " caracteres");
        }
        if (normalizado.chars().noneMatch(Character::isLetter)) {
            throw new IllegalArgumentException("el nombre debe contener al menos una letra: " + valor);
        }
        return new Nombre(normalizado);
    }

    public String valor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nombre otro)) return false;
        return valor.equals(otro.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String toString() {
        return valor;
    }
}
