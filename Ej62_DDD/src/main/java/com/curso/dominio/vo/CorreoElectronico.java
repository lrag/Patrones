package com.curso.dominio.vo;

import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;


public final class CorreoElectronico {

    //No existe expresión regular que valide el 100% de los correos electrónicos
    private static final Pattern FORMATO = Pattern.compile("^[^@\\s]+@[^@\\s.]+(\\.[^@\\s.]+)+$");
    private static final int LONGITUD_MAXIMA = 254;

    private final String valor;

    private CorreoElectronico(String valor) {
        this.valor = valor;
    }

    public static CorreoElectronico of(String valor) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("el correo electrónico no puede estar en blanco");
        }
        String normalizado = valor.strip().toLowerCase(Locale.ROOT);
        if (normalizado.length() > LONGITUD_MAXIMA) {
            throw new IllegalArgumentException("el correo electrónico es demasiado largo: " + normalizado.length());
        }
        if (!FORMATO.matcher(normalizado).matches()) {
            throw new IllegalArgumentException("el correo electrónico no es válido: " + valor);
        }
        return new CorreoElectronico(normalizado);
    }

    public String valor() {
        return valor;
    }

    public String dominio() {
        return valor.substring(valor.indexOf('@') + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CorreoElectronico otro)) return false;
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
