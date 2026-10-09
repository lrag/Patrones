package com.curso.dominio.entidad.producto;

import java.util.Objects;

public final class Cantidad {

    private final int valor;

    private Cantidad(int valor) {
        this.valor = valor;
    }

    public static Cantidad of(int valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("la cantidad debe ser mayor que cero: " + valor);
        }
        return new Cantidad(valor);
    }

    public Cantidad sumar(Cantidad otra) {
        return new Cantidad(Math.addExact(valor, otra.valor));
    }

    public int valor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cantidad otra)) return false;
        return valor == otra.valor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}
