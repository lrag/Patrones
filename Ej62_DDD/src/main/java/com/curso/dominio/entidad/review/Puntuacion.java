package com.curso.dominio.entidad.review;

import java.util.Objects;

public final class Puntuacion {

    private static final int MINIMA = 1;
    private static final int MAXIMA = 5;

    private final int estrellas;

    private Puntuacion(int estrellas) {
        this.estrellas = estrellas;
    }

    public static Puntuacion of(int estrellas) {
        if (estrellas < MINIMA || estrellas > MAXIMA) {
            throw new IllegalArgumentException(
                    "la puntuación debe estar entre " + MINIMA + " y " + MAXIMA + ": " + estrellas);
        }
        return new Puntuacion(estrellas);
    }

    public int estrellas() {
        return estrellas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Puntuacion otra)) return false;
        return estrellas == otra.estrellas;
    }

    @Override
    public int hashCode() {
        return Objects.hash(estrellas);
    }

    @Override
    public String toString() {
        return estrellas + "/" + MAXIMA;
    }
}
