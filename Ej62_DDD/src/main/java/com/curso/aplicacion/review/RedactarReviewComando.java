package com.curso.aplicacion.review;

// DTO de entrada: los datos tal como llegan, sin validar. El comentario es opcional.
public record RedactarReviewComando(String clienteId, String productoId, int puntuacion, String comentario) {
}
