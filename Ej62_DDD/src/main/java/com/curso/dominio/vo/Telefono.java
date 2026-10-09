package com.curso.dominio.vo;

import java.util.Objects;
import java.util.regex.Pattern;

public final class Telefono {

    // Admite un + inicial opcional y entre 7 y 15 dígitos (15 es el máximo del estándar E.164).
    private static final Pattern FORMATO = Pattern.compile("^\\+?\\d{7,15}$");

    private final String valor;

    private Telefono(String valor) {
        this.valor = valor;
    }

    // Se guarda sin separadores: "+34 612-345-678" y "+34612345678" son el mismo teléfono.
    public static Telefono of(String valor) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("el teléfono no puede estar en blanco");
        }
        String normalizado = valor.replaceAll("[\\s.\\-()]", "");
        if (!FORMATO.matcher(normalizado).matches()) {
            throw new IllegalArgumentException("el teléfono no es válido: " + valor);
        }
        return new Telefono(normalizado);
    }

    public String valor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Telefono otro)) return false;
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
