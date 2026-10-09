package com.curso.dominio.vo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class Porcentaje {

    private static final BigDecimal CIEN = BigDecimal.valueOf(100);

    // Sin ceros sobrantes, para que 21 y 21.0 sean el mismo porcentaje.
    private final BigDecimal valor;

    private Porcentaje(BigDecimal valor) {
        this.valor = valor.signum() == 0 ? BigDecimal.ZERO : valor.stripTrailingZeros();
    }

    public static Porcentaje of(BigDecimal valor) {
        if (valor == null) {
            throw new IllegalArgumentException("el porcentaje no puede ser nulo");
        }
        if (valor.signum() < 0 || valor.compareTo(CIEN) > 0) {
            throw new IllegalArgumentException("el porcentaje debe estar entre 0 y 100: " + valor);
        }
        return new Porcentaje(valor);
    }

    public static Porcentaje of(double valor) {
        return of(BigDecimal.valueOf(valor));
    }

    // El resultado se redondea a los decimales de la moneda (HALF_EVEN).
    public Dinero aplicarA(Dinero dinero) {
        BigDecimal resultado = dinero.importe()
                .multiply(valor)
                .divide(CIEN, dinero.moneda().getDefaultFractionDigits(), RoundingMode.HALF_EVEN);
        return Dinero.of(resultado, dinero.moneda());
    }

    public Porcentaje complementario() {
        return new Porcentaje(CIEN.subtract(valor));
    }

    public BigDecimal valor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Porcentaje otro)) return false;
        return valor.equals(otro.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String toString() {
        return valor.toPlainString() + " %";
    }
}
