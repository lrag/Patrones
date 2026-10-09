package com.curso.dominio.entidad.producto;

import java.util.Objects;

//Esto es un VO porque pudiendo ser una entidad en esta aplicación los fabricantes no tienen especial importancia
public final class Fabricante {

    private static final int LONGITUD_MAXIMA = 100;

    private final String nombre;
    private final String pais;

    private Fabricante(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public static Fabricante of(String nombre, String pais) {
        return new Fabricante(
                normalizar(nombre, "el nombre del fabricante"),
                normalizar(pais, "el país del fabricante"));
    }

    // Quita los espacios de los extremos y colapsa los repetidos: " Acme   Corp " pasa a "Acme Corp".
    private static String normalizar(String texto, String descripcion) {
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException(descripcion + " no puede estar en blanco");
        }
        String normalizado = texto.strip().replaceAll("\\s+", " ");
        if (normalizado.length() > LONGITUD_MAXIMA) {
            throw new IllegalArgumentException(descripcion + " no puede superar " + LONGITUD_MAXIMA + " caracteres");
        }
        return normalizado;
    }

    public String nombre() {
        return nombre;
    }

    public String pais() {
        return pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fabricante otro)) return false;
        return nombre.equals(otro.nombre) && pais.equals(otro.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, pais);
    }

    @Override
    public String toString() {
        return nombre + " (" + pais + ")";
    }
}
