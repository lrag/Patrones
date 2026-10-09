package com.curso.dominio.entidad.pedido;

import com.curso.dominio.entidad.producto.Cantidad;
import com.curso.dominio.entidad.producto.ProductoId;
import com.curso.dominio.vo.Dinero;
import java.util.Objects;

/*

Entidad interna (local) de un agregado:
Se diferencia de la entidad raíz (Cliente, Producto, Pedido) en lo siguiente.

Pertenece a un agregado.
    No existe por sí sola: forma parte del Pedido, que es su raíz.
    Si el pedido desaparece, sus detalles desaparecen con él.

Tiene identidad local.
    Se distingue de las demás entidades del mismo agregado (el detalle 1, el detalle 2),
    pero su identidad solo tiene sentido dentro de su raíz.
    No necesita un id global (UUID): basta un número dentro del pedido.

Igualdad por esa identidad local.
    equals y hashCode se basan en el número dentro del pedido.
    Dos detalles de pedidos distintos con el mismo número no se comparan nunca entre sí.

Solo se accede a ella a través de la raíz.
    Ningún código externo la carga, la busca ni la modifica directamente.
    Es el Pedido quien la crea, la cambia y la elimina.

No tiene repositorio.
    Se guarda y se recupera siempre junto con su raíz, como parte del agregado.

Su estado lo modifica solo la raíz.
    Los métodos que la cambian no son públicos (aumentarCantidad es del paquete).
    Desde fuera solo se puede leer.

La raíz protege las reglas que la afectan.
    Que no haya dos detalles del mismo producto, que no se modifiquen
    con el pedido pagado, que la moneda coincida: todo eso lo garantiza el Pedido.

Nadie fuera del agregado la referencia.
    Otros agregados no guardan un id de DetallePedido; si hace falta señalarla,
    se apunta al pedido y se llega a ella a través de él.

Puede referenciar a otros agregados, pero solo por id.
    Guarda el ProductoId, no el objeto Producto.

Comparte el ciclo de vida y la transacción de su raíz.
    Se crea, se modifica y se guarda en la misma transacción que el Pedido.

*/

/*

Qué garantiza y qué no garantiza la entidad interna DetallePedido:

GARANTIZA

Datos válidos desde su creación.
    Número mayor que cero, producto presente, nombre del producto no vacío,
    precio unitario no negativo y cantidad presente.

Subtotal correcto.
    No se guarda: se calcula como precio unitario por cantidad.

Copia fiel de la compra.
    Producto, nombre y precio unitario son finales y no cambian nunca,
    aunque el producto cambie después en el catálogo.

Cambios controlados.
    Lo único que puede cambiar es la cantidad, y solo aumentándola,
    mediante un método que solo puede usar el Pedido (visibilidad de paquete).

Identidad local estable.
    El número no cambia, así que equals y hashCode tampoco.

NO GARANTIZA

Que su número sea único dentro del pedido.
    Lo garantiza el Pedido.

Que el precio esté en la moneda del pedido.
    También lo comprueba el Pedido.

Que el producto exista ni que el nombre y el precio sean los del catálogo.
    Solo guarda lo que le pasan.

Que haya stock para esa cantidad.
    No conoce el inventario.

Que pertenezca a un pedido.
    DetallePedido.of es público (para poder reconstruir), así que puede crearse un detalle suelto;
    solo tiene sentido dentro de un Pedido.

*/

//Esto es una entidad local al agregado Pedido
//Y a su vez un agregado
public class DetallePedido {

    private final int numero;
    
    //Una entidad local puede ser un agregado
    //Aqui referenciamos el producto con su ID
    private final ProductoId productoId;
    // Copias de los datos del producto en el momento de la compra: el pedido no cambia si el producto cambia.
    private final String nombreProducto;
    private final Dinero precioUnitario;
    private Cantidad cantidad;

    private DetallePedido(int numero, ProductoId productoId, String nombreProducto, Dinero precioUnitario,
                          Cantidad cantidad) {
        this.numero = numero;
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    public static DetallePedido of(int numero, ProductoId productoId, String nombreProducto, Dinero precioUnitario,
                                   Cantidad cantidad) {
        if (numero <= 0) {
            throw new IllegalArgumentException("el número de detalle debe ser mayor que cero: " + numero);
        }
        if (productoId == null) {
            throw new IllegalArgumentException("el producto del detalle no puede ser nulo");
        }
        if (nombreProducto == null || nombreProducto.isBlank()) {
            throw new IllegalArgumentException("el nombre del producto no puede estar en blanco");
        }
        if (precioUnitario == null) {
            throw new IllegalArgumentException("el precio unitario del detalle no puede ser nulo");
        }
        if (precioUnitario.esNegativo()) {
            throw new IllegalArgumentException("el precio unitario no puede ser negativo: " + precioUnitario);
        }
        if (cantidad == null) {
            throw new IllegalArgumentException("la cantidad del detalle no puede ser nula");
        }
        return new DetallePedido(numero, productoId, nombreProducto.strip(), precioUnitario, cantidad);
    }

    // Solo lo invoca el Pedido, que es quien garantiza las reglas del conjunto.
    void aumentarCantidad(Cantidad adicional) {
        this.cantidad = cantidad.sumar(adicional);
    }

    public Dinero subtotal() {
        return precioUnitario.multiplicar(cantidad.valor());
    }

    public int numero() {
        return numero;
    }

    public ProductoId productoId() {
        return productoId;
    }

    public String nombreProducto() {
        return nombreProducto;
    }

    public Dinero precioUnitario() {
        return precioUnitario;
    }

    public Cantidad cantidad() {
        return cantidad;
    }

    // Identidad local: el número dentro del pedido. Dos detalles con el mismo número son el mismo detalle.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetallePedido otro)) return false;
        return numero == otro.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public String toString() {
        return "Detalle " + numero + ": " + cantidad + " x " + nombreProducto + " (" + precioUnitario + ")";
    }
}
