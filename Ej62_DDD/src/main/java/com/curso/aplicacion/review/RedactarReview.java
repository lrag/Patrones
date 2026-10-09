package com.curso.aplicacion.review;

import com.curso.aplicacion.cliente.ClienteNoEncontradoException;
import com.curso.aplicacion.cliente.RepositorioClientes;
import com.curso.aplicacion.pedido.RepositorioPedidos;
import com.curso.aplicacion.producto.ProductoNoEncontradoException;
import com.curso.aplicacion.producto.RepositorioProductos;
import com.curso.dominio.entidad.cliente.ClienteId;
import com.curso.dominio.entidad.pedido.Pedido;
import com.curso.dominio.entidad.producto.ProductoId;
import com.curso.dominio.entidad.review.Puntuacion;
import com.curso.dominio.entidad.review.Review;
import com.curso.dominio.entidad.review.ReviewId;
import com.curso.dominio.servicio.PoliticaDeReviews;
import java.time.Clock;
import java.time.LocalDate;
import java.util.List;

// Servicio de aplicación del caso de uso "un cliente hace una review de un producto": carga los datos
// que la regla necesita (los pedidos y las reviews del cliente), le pregunta al servicio de dominio
// si puede hacerla y, si es así, crea la Review y la guarda.
public class RedactarReview {

    private final RepositorioClientes clientes;
    private final RepositorioProductos productos;
    private final RepositorioPedidos pedidos;
    private final RepositorioReviews reviews;
    private final PoliticaDeReviews politica;
    private final Clock reloj;

    public RedactarReview(
    		RepositorioClientes clientes, 
    		RepositorioProductos productos, 
    		RepositorioPedidos pedidos,
            RepositorioReviews reviews, 
            PoliticaDeReviews politica
        ) {
        this(clientes, productos, pedidos, reviews, politica, Clock.systemDefaultZone());
    }

    public RedactarReview(RepositorioClientes clientes, RepositorioProductos productos, RepositorioPedidos pedidos,
                          RepositorioReviews reviews, PoliticaDeReviews politica, Clock reloj) {
        this.clientes = clientes;
        this.productos = productos;
        this.pedidos = pedidos;
        this.reviews = reviews;
        this.politica = politica;
        this.reloj = reloj;
    }

    public ReviewId ejecutar(RedactarReviewComando comando) {
        if (comando == null) {
            throw new IllegalArgumentException("el comando no puede ser nulo");
        }

        // Del DTO a los Value Objects: se valida antes de consultar nada.
        ClienteId clienteId = ClienteId.of(comando.clienteId());
        ProductoId productoId = ProductoId.of(comando.productoId());
        Puntuacion puntuacion = Puntuacion.of(comando.puntuacion());

        if(clientes.buscarPorId(clienteId).isEmpty()) {
            throw new ClienteNoEncontradoException(clienteId);
        }
        if(productos.buscarPorId(productoId).isEmpty()) {
            throw new ProductoNoEncontradoException(productoId);
        }

        // La regla necesita datos de otros agregados: aquí se cargan y se le pasan al servicio de dominio.
        List<Pedido> pedidosDelCliente = pedidos.buscarPorCliente(clienteId);
        List<Review> reviewsDelCliente = reviews.buscarPorCliente(clienteId);
        if(!politica.puedeHacerReview(productoId, pedidosDelCliente, reviewsDelCliente)) {
            throw new ReviewNoPermitidaException(clienteId, productoId);
        }

        Review review = Review.redactar(productoId, clienteId, LocalDate.now(reloj), puntuacion,
                comando.comentario());
        reviews.guardar(review);
        return review.id();
    }
}
