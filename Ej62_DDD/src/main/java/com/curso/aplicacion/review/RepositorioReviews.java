package com.curso.aplicacion.review;

import com.curso.dominio.entidad.cliente.ClienteId;
import com.curso.dominio.entidad.review.Review;
import com.curso.dominio.entidad.review.ReviewId;
import java.util.List;
import java.util.Optional;

public interface RepositorioReviews {

    void guardar(Review review);

    Optional<Review> buscarPorId(ReviewId id);

    List<Review> buscarPorCliente(ClienteId clienteId);
}
