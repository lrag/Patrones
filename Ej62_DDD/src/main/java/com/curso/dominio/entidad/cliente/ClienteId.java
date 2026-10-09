package com.curso.dominio.entidad.cliente;

import java.util.Objects;
import java.util.UUID;

public final class ClienteId {

    private final UUID valor;

    private ClienteId(UUID valor) {
        this.valor = valor;
    }

    // Genera una identidad nueva; el id se asigna al crear el cliente, sin esperar a la base de datos.
    public static ClienteId nuevo() {
        return new ClienteId(UUID.randomUUID());
    }

    public static ClienteId of(UUID valor) {
        if (valor == null) {
            throw new IllegalArgumentException("el id del cliente no puede ser nulo");
        }
        return new ClienteId(valor);
    }

    public static ClienteId of(String valor) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("el id del cliente no puede estar en blanco");
        }
        try {
            return new ClienteId(UUID.fromString(valor.strip()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("el id del cliente no es un UUID válido: " + valor, e);
        }
    }

    public UUID valor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClienteId otro)) return false;
        return valor.equals(otro.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String toString() {
        return valor.toString();
    }
}
