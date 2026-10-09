package com.curso.dominio.entidad.producto;

import java.util.Objects;

//Este es un VO de libro
public final class Caracteristica {

    private static final int LONGITUD_MAXIMA_NOMBRE = 50;
    private static final int LONGITUD_MAXIMA_VALOR = 200;

    private final String nombre;
    private final String valor;

    private Caracteristica(String nombre, String valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public static Caracteristica of(String nombre, String valor) {
        return new Caracteristica(
                normalizar(nombre, "el nombre de la característica", LONGITUD_MAXIMA_NOMBRE),
                normalizar(valor, "el valor de la característica", LONGITUD_MAXIMA_VALOR));
    }

    private static String normalizar(String texto, String descripcion, int longitudMaxima) {
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException(descripcion + " no puede estar en blanco");
        }
        String normalizado = texto.strip().replaceAll("\\s+", " ");
        if (normalizado.length() > longitudMaxima) {
            throw new IllegalArgumentException(descripcion + " no puede superar " + longitudMaxima + " caracteres");
        }
        return normalizado;
    }

    public String nombre() {
        return nombre;
    }

    public String valor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Caracteristica otra)) return false;
        return nombre.equals(otra.nombre) && valor.equals(otra.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, valor);
    }

    @Override
    public String toString() {
        return nombre + ": " + valor;
    }
}
