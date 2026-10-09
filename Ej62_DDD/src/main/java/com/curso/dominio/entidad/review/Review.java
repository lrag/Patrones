package com.curso.dominio.entidad.review;

import com.curso.dominio.entidad.cliente.ClienteId;
import com.curso.dominio.entidad.producto.ProductoId;
import java.time.LocalDate;
import java.util.Objects;

/*

Qué garantiza y qué no garantiza el agregado Review:

GARANTIZA

Datos obligatorios siempre presentes.
    Id, producto, cliente, fecha de creación y puntuación nunca son nulos.

Puntuación válida.
    Siempre entre 1 y 5, porque es un Value Object.

Comentario bien formado.
    Es opcional (sin comentario es una cadena vacía), nunca es nulo,
    se le quitan los espacios de los extremos y no supera 1000 caracteres.

Autoría y origen inmutables.
    El producto, el cliente autor y la fecha de creación no cambian nunca.

Cambios controlados.
    Lo único que se puede cambiar es la puntuación y el comentario, con editar.

Identidad estable.
    equals y hashCode dependen solo del id, así que editarla no cambia qué review es.

NO GARANTIZA

Que un cliente haga una review de un producto solo una vez.
    Tendría que consultar las demás reviews.

Que el cliente haya comprado el producto.
    Tendría que consultar sus pedidos.

Que el producto y el cliente existan.
    Solo guarda sus ids.

Que solo el autor la edite.
    editar no recibe quién la edita.

Que el contenido sea adecuado.
    No hay moderación del comentario.

Que las fechas tengan sentido.
    La fecha de creación puede ser futura o anterior al alta del producto,
    y no se registra cuándo se editó.

Concurrencia.
    No lleva versión: dos ediciones simultáneas pueden pisarse.

*/
public class Review {

    private static final int COMENTARIO_MAXIMO = 1000;

    private final ReviewId id;
    // Producto y Cliente son otros agregados: se referencian solo por su id.
    private final ProductoId productoId;
    private final ClienteId clienteId;
    private final LocalDate fechaCreacion;
    private Puntuacion puntuacion;
    private String comentario;

    private Review(ReviewId id, ProductoId productoId, ClienteId clienteId, LocalDate fechaCreacion,
                   Puntuacion puntuacion, String comentario) {
        this.id = id;
        this.productoId = productoId;
        this.clienteId = clienteId;
        this.fechaCreacion = fechaCreacion;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
    }

    // Reconstruye una review existente. El comentario es opcional: null equivale a "sin comentario".
    public static Review of(ReviewId id, ProductoId productoId, ClienteId clienteId, LocalDate fechaCreacion,
                            Puntuacion puntuacion, String comentario) {
        if (id == null) {
            throw new IllegalArgumentException("el id de la review no puede ser nulo");
        }
        if (productoId == null) {
            throw new IllegalArgumentException("el producto de la review no puede ser nulo");
        }
        if (clienteId == null) {
            throw new IllegalArgumentException("el cliente de la review no puede ser nulo");
        }
        if (fechaCreacion == null) {
            throw new IllegalArgumentException("la fecha de creación de la review no puede ser nula");
        }
        if (puntuacion == null) {
            throw new IllegalArgumentException("la puntuación de la review no puede ser nula");
        }
        return new Review(id, productoId, clienteId, fechaCreacion, puntuacion, normalizarComentario(comentario));
    }

    // Publica una review nueva, con una identidad recién generada.
    public static Review redactar(ProductoId productoId, ClienteId clienteId, LocalDate fechaCreacion,
                                  Puntuacion puntuacion, String comentario) {
        return of(ReviewId.nuevo(), productoId, clienteId, fechaCreacion, puntuacion, comentario);
    }

    // El autor puede corregir su valoración; el producto, el autor y la fecha original no cambian.
    public void editar(Puntuacion nuevaPuntuacion, String nuevoComentario) {
        if (nuevaPuntuacion == null) {
            throw new IllegalArgumentException("la puntuación de la review no puede ser nula");
        }
        this.puntuacion = nuevaPuntuacion;
        this.comentario = normalizarComentario(nuevoComentario);
    }

    private static String normalizarComentario(String comentario) {
        if (comentario == null) {
            return "";
        }
        String normalizado = comentario.strip();
        if (normalizado.length() > COMENTARIO_MAXIMO) {
            throw new IllegalArgumentException(
                    "el comentario no puede superar " + COMENTARIO_MAXIMO + " caracteres");
        }
        return normalizado;
    }

    public ReviewId id() {
        return id;
    }

    public ProductoId productoId() {
        return productoId;
    }

    public ClienteId clienteId() {
        return clienteId;
    }

    public LocalDate fechaCreacion() {
        return fechaCreacion;
    }

    public Puntuacion puntuacion() {
        return puntuacion;
    }

    public String comentario() {
        return comentario;
    }

    // Igualdad por identidad, igual que en el resto de raíces.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review otra)) return false;
        return id.equals(otra.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Review " + id;
    }
}
