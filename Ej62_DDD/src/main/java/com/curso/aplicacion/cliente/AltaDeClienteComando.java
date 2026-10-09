package com.curso.aplicacion.cliente;

// DTO de entrada del caso de uso: los datos tal como llegan (textos sin validar), sin lógica de negocio.
// El servicio de aplicación los convierte en Value Objects, y es en esa conversión donde se validan.
public record AltaDeClienteComando(
        String nombre,
        String calle,
        String ciudad,
        String codigoPostal,
        String pais,
        String correo,
        String telefono) {
}
