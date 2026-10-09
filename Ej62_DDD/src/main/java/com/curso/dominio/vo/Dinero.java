package com.curso.dominio.vo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Objects;

public final class Dinero {

    private final BigDecimal importe;
    private final Currency moneda;

    private Dinero(BigDecimal importe, Currency moneda) {
        this.importe = importe;
        this.moneda = moneda;
    }

    // El importe se fija a los decimales de la moneda (2 para EUR, 0 para JPY...).
    // Si trae más decimales de los que admite la moneda se rechaza, en lugar de redondear en silencio.
    public static Dinero of(BigDecimal importe, Currency moneda) {
        if (importe == null) {
            throw new IllegalArgumentException("el importe no puede ser nulo");
        }
        if (moneda == null) {
            throw new IllegalArgumentException("la moneda no puede ser nula");
        }
        try {
            return new Dinero(importe.setScale(moneda.getDefaultFractionDigits(), RoundingMode.UNNECESSARY), moneda);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException(
                    "el importe " + importe + " tiene más decimales de los que admite " + moneda, e);
        }
    }

    public static Dinero of(String importe, String codigoMoneda) {
        return of(new BigDecimal(importe), Currency.getInstance(codigoMoneda));
    }

    public static Dinero cero(Currency moneda) {
        return of(BigDecimal.ZERO, moneda);
    }

    public Dinero sumar(Dinero otro) {
        comprobarMismaMoneda(otro);
        return new Dinero(importe.add(otro.importe), moneda);
    }

    public Dinero restar(Dinero otro) {
        comprobarMismaMoneda(otro);
        return new Dinero(importe.subtract(otro.importe), moneda);
    }

    public Dinero multiplicar(int factor) {
        return new Dinero(importe.multiply(BigDecimal.valueOf(factor)), moneda);
    }

    public boolean esMayorQue(Dinero otro) {
        comprobarMismaMoneda(otro);
        return importe.compareTo(otro.importe) > 0;
    }

    public boolean esNegativo() {
        return importe.signum() < 0;
    }

    private void comprobarMismaMoneda(Dinero otro) {
        if (!moneda.equals(otro.moneda)) {
            throw new IllegalArgumentException("monedas distintas: " + moneda + " y " + otro.moneda);
        }
    }

    public BigDecimal importe() {
        return importe;
    }

    public Currency moneda() {
        return moneda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dinero otro)) return false;
        return importe.equals(otro.importe) && moneda.equals(otro.moneda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(importe, moneda);
    }

    @Override
    public String toString() {
        return importe.toPlainString() + " " + moneda.getCurrencyCode();
    }
}
