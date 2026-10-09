package com.curso.dominio.servicio;

import com.curso.dominio.entidad.pedido.EstadoPedido;
import com.curso.dominio.entidad.pedido.Pedido;
import com.curso.dominio.entidad.producto.ProductoId;
import com.curso.dominio.entidad.review.Review;

import java.util.List;

/*

Servicio de dominio:

Contiene una regla de negocio que no encaja en una entidad ni en un VO.
    Suele afectar a varios agregados, o necesitar datos que ninguno tiene por sí solo.
    Aquí, la regla afecta a Pedido, Cliente y Review, y no corresponde a ninguno de los dos.

Es una operación, no una entidad.
    Representa una acción o una decisión del negocio (calcular, asignar, comprobar)
    No tiene identidad ni ciclo de vida.
    Contiene funciones puras
    	que son perfectamente THREAD SAFE

No tiene estado.
    No guarda datos entre llamadas: recibe lo que necesita y devuelve un resultado.

Se nombra en el lenguaje ubicuo.
    Su nombre y el de sus métodos son los que usaría el negocio (puedeHacerReview).

Opera con objetos del dominio.
    Recibe y devuelve entidades, VOs e ids, no DTOs ni filas de base de datos.

Es independiente de la infraestructura.
    No conoce bases de datos, frameworks (spring si) ni servicios externos.
    No usa repositorios: quien lo invoca (un servicio de aplicación) carga los datos y se los pasa.

Se usa cuando la regla no cabe en un agregado.
    Si se puede decidir con los datos de un solo agregado, la regla va en ese agregado.
    Abusar de los servicios de dominio deja las entidades vacías (modelo anémico).

No es un servicio de aplicación.
    El de aplicación orquesta un caso de uso (cargar, llamar, guardar, gestionar la transacción)
    y no contiene reglas de negocio. El de dominio contiene la regla y no orquesta nada.

Por contrato, los pedidos y las reviews que recibe son todos del mismo cliente.
    No lo vuelve a comprobar: es responsabilidad de quien los carga.

*/
public class PoliticaDeReviews {

    // Un cliente puede hacer una review de un producto si lo ha recibido y todavía no la ha hecho.
    public boolean puedeHacerReview(ProductoId productoId, List<Pedido> pedidosDelCliente,
                                List<Review> reviewsDelCliente) {
        if (productoId == null) {
            throw new IllegalArgumentException("el producto no puede ser nulo");
        }
        if (pedidosDelCliente == null || reviewsDelCliente == null) {
            throw new IllegalArgumentException("los pedidos y las reviews no pueden ser nulos");
        }
        return haRecibido(productoId, pedidosDelCliente) && !yaHaHechoReview(productoId, reviewsDelCliente);
    }

    // Solo cuenta un pedido ya entregado: no vale uno pagado, enviado o cancelado.
    private boolean haRecibido(ProductoId productoId, List<Pedido> pedidos) {
        return pedidos.stream()
                .filter(pedido -> pedido.estado() == EstadoPedido.ENTREGADO)
                .anyMatch(pedido -> pedido.detalles().stream()
                .anyMatch(detalle -> detalle.productoId().equals(productoId)));
    }

    private boolean yaHaHechoReview(ProductoId productoId, List<Review> reviews) {
        return reviews.stream().anyMatch(review -> review.productoId().equals(productoId));
    }
}
