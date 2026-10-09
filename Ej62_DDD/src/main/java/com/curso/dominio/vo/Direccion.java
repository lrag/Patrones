package com.curso.dominio.vo;

import java.util.Objects;

public final class Direccion {

    private final String calle;
    private final String ciudad;
    private final String codigoPostal;
    private final String pais;

    private Direccion(String calle, String ciudad, String codigoPostal, String pais) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
    }

    public static Direccion of(String calle, String ciudad, String codigoPostal, String pais) {
        if (calle == null || calle.isBlank()) {
            throw new IllegalArgumentException("la calle no puede estar en blanco");
        }
        if (ciudad == null || ciudad.isBlank()) {
            throw new IllegalArgumentException("la ciudad no puede estar en blanco");
        }
        if (codigoPostal == null || codigoPostal.isBlank()) {
            throw new IllegalArgumentException("el código postal no puede estar en blanco");
        }
        if (pais == null || pais.isBlank()) {
            throw new IllegalArgumentException("el país no puede estar en blanco");
        }
        return new Direccion(calle.strip(), ciudad.strip(), codigoPostal.strip(), pais.strip());
    }

    public String calle() {
        return calle;
    }

    public String ciudad() {
        return ciudad;
    }

    public String codigoPostal() {
        return codigoPostal;
    }

    public String pais() {
        return pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Direccion otra)) return false;
        return calle.equals(otra.calle)
                && ciudad.equals(otra.ciudad)
                && codigoPostal.equals(otra.codigoPostal)
                && pais.equals(otra.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(calle, ciudad, codigoPostal, pais);
    }

    @Override
    public String toString() {
        return calle + ", " + codigoPostal + " " + ciudad + " (" + pais + ")";
    }
}
