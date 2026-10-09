package com.curso.dominio.vo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class Distancia {

    public enum Unidad {
        METRO("1"), KILOMETRO("1000"), MILLA("1609.344");

        private final BigDecimal metros;

        Unidad(String metros) {
            this.metros = new BigDecimal(metros);
        }
    }

    private static final int DECIMALES_CONVERSION = 6;

    //Representación interna única: metros, sin ceros sobrantes (1 km y 1000 m son la misma distancia).
    private final BigDecimal metros;

    private Distancia(BigDecimal metros) {
        this.metros = metros.stripTrailingZeros();
    }

    public static Distancia of(BigDecimal valor, Unidad unidad) {
        if (valor == null) {
            throw new IllegalArgumentException("el valor no puede ser nulo");
        }
        if (unidad == null) {
            throw new IllegalArgumentException("la unidad no puede ser nula");
        }
        if (valor.signum() < 0) {
            throw new IllegalArgumentException("la distancia no puede ser negativa: " + valor);
        }
        return new Distancia(valor.multiply(unidad.metros));
    }

    public static Distancia of(double valor, Unidad unidad) {
        return of(BigDecimal.valueOf(valor), unidad);
    }

    public BigDecimal en(Unidad unidad) {
        return metros.divide(unidad.metros, DECIMALES_CONVERSION, RoundingMode.HALF_EVEN).stripTrailingZeros();
    }

    public Distancia sumar(Distancia otra) {
        return new Distancia(metros.add(otra.metros));
    }

    public Distancia restar(Distancia otra) {
        if (otra.metros.compareTo(metros) > 0) {
            throw new IllegalArgumentException("la distancia resultante sería negativa: " + this + " - " + otra);
        }
        return new Distancia(metros.subtract(otra.metros));
    }

    public boolean esMayorQue(Distancia otra) {
        return metros.compareTo(otra.metros) > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Distancia otra)) return false;
        return metros.equals(otra.metros);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metros);
    }

    @Override
    public String toString() {
        return metros.toPlainString() + " m";
    }
}
