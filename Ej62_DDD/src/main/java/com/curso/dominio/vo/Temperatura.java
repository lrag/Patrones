package com.curso.dominio.vo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class Temperatura {

    public enum Escala { CELSIUS, FAHRENHEIT, KELVIN }

    private static final BigDecimal CERO_ABSOLUTO_EN_CELSIUS = new BigDecimal("273.15");
    private static final BigDecimal TREINTA_Y_DOS = BigDecimal.valueOf(32);
    private static final BigDecimal NUEVE = BigDecimal.valueOf(9);
    private static final BigDecimal CINCO = BigDecimal.valueOf(5);
    private static final int DECIMALES = 2;

    // Representación interna única: kelvin con 2 decimales. Así 0 ºC y 32 ºF son la misma temperatura.
    private final BigDecimal kelvin;

    private Temperatura(BigDecimal kelvin) {
        this.kelvin = kelvin;
    }

    public static Temperatura of(BigDecimal valor, Escala escala) {
        if (valor == null) {
            throw new IllegalArgumentException("el valor no puede ser nulo");
        }
        if (escala == null) {
            throw new IllegalArgumentException("la escala no puede ser nula");
        }
        BigDecimal kelvin = switch (escala) {
            case KELVIN -> valor;
            case CELSIUS -> valor.add(CERO_ABSOLUTO_EN_CELSIUS);
            case FAHRENHEIT -> valor.subtract(TREINTA_Y_DOS)
                    .multiply(CINCO).divide(NUEVE, 10, RoundingMode.HALF_EVEN)
                    .add(CERO_ABSOLUTO_EN_CELSIUS);
        };
        kelvin = kelvin.setScale(DECIMALES, RoundingMode.HALF_EVEN);
        if (kelvin.signum() < 0) {
            throw new IllegalArgumentException("por debajo del cero absoluto: " + valor + " " + escala);
        }
        return new Temperatura(kelvin);
    }

    public static Temperatura of(double valor, Escala escala) {
        return of(BigDecimal.valueOf(valor), escala);
    }

    public BigDecimal en(Escala escala) {
        return switch (escala) {
            case KELVIN -> kelvin;
            case CELSIUS -> kelvin.subtract(CERO_ABSOLUTO_EN_CELSIUS);
            case FAHRENHEIT -> kelvin.subtract(CERO_ABSOLUTO_EN_CELSIUS)
                    .multiply(NUEVE).divide(CINCO, DECIMALES, RoundingMode.HALF_EVEN)
                    .add(TREINTA_Y_DOS);
        };
    }

    public boolean esMayorQue(Temperatura otra) {
        return kelvin.compareTo(otra.kelvin) > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Temperatura otra)) return false;
        return kelvin.equals(otra.kelvin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kelvin);
    }

    @Override
    public String toString() {
        return en(Escala.CELSIUS) + " ºC";
    }
}
