package com.curso.dominio.entidad.pedido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.curso.dominio.entidad.cliente.ClienteId;
import com.curso.dominio.entidad.producto.Cantidad;
import com.curso.dominio.entidad.producto.ProductoId;
import com.curso.dominio.vo.Dinero;
import com.curso.dominio.vo.Direccion;

/*

Agregado 

Es un grupo de objetos que se trata como una unidad.
    Agrupa una entidad raíz (Pedido), entidades internas (DetallePedido)
    y Value Objects (Direccion, Dinero, Cantidad).

Tiene una única raíz.
    Es la entidad que da nombre y identidad al agregado, y la única puerta de entrada.
    Desde fuera nadie toca un DetallePedido directamente: se pide al Pedido.

Tiene identidad global, la de su raíz.
    PedidoId identifica el agregado completo.
    Las entidades internas solo tienen identidad local.

Es el límite de consistencia.
    Todo lo que hay dentro es coherente en todo momento.
    Las reglas que afectan a varios de sus elementos las garantiza la raíz.

Protege sus invariantes.
    Que el total sea la suma de los detalles, que no haya dos detalles del mismo producto,
    que la moneda coincida, que no se modifique tras pagar.
    Ninguna operación deja el agregado en un estado inválido.

Es la unidad de transacción.
    Se guarda y se modifica entera en una sola transacción.
    No se modifican dos agregados en la misma transacción.

Se carga y se guarda entero, a través de su repositorio.
    El repositorio solo trabaja con raíces.
    Nunca se recupera un DetallePedido suelto.

Referencia a otros agregados solo por su id.
    Guarda ClienteId y, en cada detalle, ProductoId. Nunca los objetos Cliente o Producto.

Se modifica con operaciones del negocio.
    addProducto, pagar, enviar, cancelar: expresan el lenguaje ubicuo
    y comprueban las reglas, en lugar de exponer setters.

No expone su estado interno modificable.
    detalles() devuelve una copia inmutable.
    Las entidades internas solo se cambian a través de la raíz.

Su ciclo de vida lo controla la raíz.
    Si el Pedido deja de existir, sus detalles también.

Es independiente de la infraestructura.
    No conoce bases de datos, frameworks ni otros servicios.

Es pequeño.
    Solo contiene lo que necesita ser consistente en el mismo instante;
    lo demás va en otros agregados, enlazados por id.

*/

/*

Qué garantiza y qué no garantiza el agregado Pedido:

GARANTIZA

El total es correcto.
    No se guarda: se calcula en cada consulta como la suma de los subtotales de los detalles,
    así que no puede quedar desincronizado.

Una única moneda.
    Todos los detalles están en la moneda del pedido y el total se expresa en ella.

Sin productos duplicados.
    Si el producto ya está, se acumula la cantidad en su detalle.
    Si llega con otro precio, se rechaza.

Detalles bien numerados.
    Los números de detalle no se repiten ni se reutilizan al quitar un producto.

El contenido solo cambia antes de pagar.
    Añadir y quitar productos solo es posible con el pedido en CREADO.

Un orden de estados válido.
    CREADO -> PAGADO -> ENVIADO -> ENTREGADO.
    No se paga un pedido sin productos y no se cancela uno ya enviado.

La dirección de envío no cambia tras el envío.
    Solo se puede cambiar en CREADO o PAGADO.

Datos obligatorios siempre presentes.
    Id, cliente, fecha de creación, moneda, dirección y estado nunca son nulos.
    Id, cliente, fecha de creación y moneda no cambian nunca.

Estado interno protegido.
    detalles() devuelve una copia inmutable.

Reconstrucción coherente de los detalles.
    Al reconstruir con of se rechazan detalles con números repetidos,
    productos repetidos o en otra moneda.

NO GARANTIZA

Que el cliente exista.
    Solo guarda un ClienteId.

Que los productos existan, estén a la venta y sean los que dice.
    Se fía del ProductoId, del nombre y del precio que se le pasan.

Que haya stock.
    No conoce el inventario.

Que el pago o el envío hayan ocurrido de verdad.
    pagar() y enviar() solo cambian el estado; no hablan con la pasarela ni con el transportista.

Que la dirección sea entregable ni que sea la del cliente.
    Es un dato que recibe, sin cotejarlo con Cliente.

Límites de negocio.
    No hay máximo de líneas, de cantidad por línea ni de importe total.

Coherencia entre el estado y los detalles al reconstruir.
    of acepta, por ejemplo, un pedido PAGADO sin detalles.

Quién puede operar.
    No hay autorización: quien tenga el pedido puede cancelarlo.

Que las fechas tengan sentido.
    La fecha de creación puede ser futura.

Concurrencia.
    No lleva versión: dos usuarios que modifican el mismo pedido a la vez pueden pisarse.

Consistencia con otros agregados.
    Pagar el pedido y descontar el stock son transacciones distintas.

*/

public class Pedido {

	/*
    VO 		  private final PedidoId id;
    EN 		  private final ClienteId clienteId;
    VO (api)  		private final Currency moneda;
    VO		  		private Direccion direccionEnvio;
    VO (enum) 		private EstadoPedido estado;
    Entidad local	private final List<DetallePedido> detalles;
      		  		private int ultimoNumeroDetalle;
    VO (api)  		private final LocalDate fechaCreacion;
	*/
	
    public final PedidoId id;
    //Cliente es otro agregado: se referencia solo por su id.
    private final ClienteId clienteId;
    private final Currency moneda;
    //Copia de la dirección del cliente al hacer el pedido: si el cliente se muda, el pedido conserva la suya.
    private Direccion direccionEnvio;
    private EstadoPedido estado;
    //DetallePedido es una entidad pero que solo tiene sentido dentro del pedido
    //Es una entidad local. No tiene "vida propia"
    //Se referencia desde aqui con no con su id sino con la referencia    
    private final List<DetallePedido> detalles;
    private int ultimoNumeroDetalle;
    //LocalDate es un VO que representa a una cantidad con nombre y que viene de regalo en el api de Java
    private final LocalDate fechaCreacion;
    
    private Pedido(PedidoId id, ClienteId clienteId, LocalDate fechaCreacion, Currency moneda,
                   Direccion direccionEnvio, EstadoPedido estado) {
        this.id = id;
        this.clienteId = clienteId;
        this.fechaCreacion = fechaCreacion;
        this.moneda = moneda;
        this.direccionEnvio = direccionEnvio;
        this.estado = estado;
        this.detalles = new ArrayList<>();
    }

    // Reconstruye un pedido existente. Los detalles son opcionales: null equivale a "sin detalles".
    public static Pedido of(PedidoId id, ClienteId clienteId, LocalDate fechaCreacion, Currency moneda,
                            Direccion direccionEnvio, EstadoPedido estado, List<DetallePedido> detalles) {
        if (id == null) {
            throw new IllegalArgumentException("el id del pedido no puede ser nulo");
        }
        if (clienteId == null) {
            throw new IllegalArgumentException("el cliente del pedido no puede ser nulo");
        }
        if (fechaCreacion == null) {
            throw new IllegalArgumentException("la fecha de creación del pedido no puede ser nula");
        }
        if (moneda == null) {
            throw new IllegalArgumentException("la moneda del pedido no puede ser nula");
        }
        if (direccionEnvio == null) {
            throw new IllegalArgumentException("la dirección de envío del pedido no puede ser nula");
        }
        if (estado == null) {
            throw new IllegalArgumentException("el estado del pedido no puede ser nulo");
        }
        Pedido pedido = new Pedido(id, clienteId, fechaCreacion, moneda, direccionEnvio, estado);
        if (detalles != null) {
            Set<Integer> numeros = new HashSet<>();
            Set<ProductoId> productos = new HashSet<>();
            for (DetallePedido detalle : detalles) {
                if (detalle == null) {
                    throw new IllegalArgumentException("el detalle del pedido no puede ser nulo");
                }
                pedido.comprobarMoneda(detalle.precioUnitario());
                if (!numeros.add(detalle.numero())) {
                    throw new IllegalArgumentException("número de detalle repetido: " + detalle.numero());
                }
                if (!productos.add(detalle.productoId())) {
                    throw new IllegalArgumentException("producto repetido en los detalles: " + detalle.productoId());
                }
                pedido.detalles.add(detalle);
                pedido.ultimoNumeroDetalle = Math.max(pedido.ultimoNumeroDetalle, detalle.numero());
            }
        }
        return pedido;
    }

    // Crea un pedido nuevo, con una identidad recién generada, en estado CREADO y sin detalles.
    public static Pedido registrar(ClienteId clienteId, LocalDate fechaCreacion, Currency moneda,
                                   Direccion direccionEnvio) {
        return of(PedidoId.nuevo(), clienteId, fechaCreacion, moneda, direccionEnvio, EstadoPedido.CREADO, null);
    }

    // Si el producto ya está en el pedido se acumula la cantidad en su detalle, no se crea otro.
    public void addProducto(
    		ProductoId productoId, 
    		String     nombreProducto, 
    		Dinero     precioUnitario, 
    		Cantidad   cantidad
		) {
        comprobarEstado("añadir productos", EstadoPedido.CREADO);
        if (precioUnitario == null) {
            throw new IllegalArgumentException("el precio unitario del pedido no puede ser nulo");
        }
        comprobarMoneda(precioUnitario);
        DetallePedido existente = buscar(productoId);
        if (existente == null) {
            detalles.add(DetallePedido.of(++ultimoNumeroDetalle, productoId, nombreProducto, precioUnitario, cantidad));
            return;
        }
        if (!existente.precioUnitario().equals(precioUnitario)) {
            throw new IllegalArgumentException("el producto " + productoId + " ya está en el pedido con otro precio");
        }
        if (cantidad == null) {
            throw new IllegalArgumentException("la cantidad del pedido no puede ser nula");
        }
        existente.aumentarCantidad(cantidad);
    }

    public void quitarProducto(ProductoId productoId) {
        comprobarEstado("quitar productos", EstadoPedido.CREADO);
        DetallePedido existente = buscar(productoId);
        if (existente == null) {
            throw new IllegalArgumentException("el pedido no contiene el producto " + productoId);
        }
        detalles.remove(existente);
    }

    public void cambiarDireccionEnvio(Direccion nueva) {
        comprobarEstado("cambiar la dirección de envío", EstadoPedido.CREADO, EstadoPedido.PAGADO);
        if (nueva == null) {
            throw new IllegalArgumentException("la dirección de envío del pedido no puede ser nula");
        }
        this.direccionEnvio = nueva;
    }

    public void pagar() {
        comprobarEstado("pagar", EstadoPedido.CREADO);
        if (detalles.isEmpty()) {
            throw new IllegalStateException("un pedido sin productos no se puede pagar");
        }
        this.estado = EstadoPedido.PAGADO;
    }

    public void enviar() {
        comprobarEstado("enviar", EstadoPedido.PAGADO);
        this.estado = EstadoPedido.ENVIADO;
    }

    public void entregar() {
        comprobarEstado("entregar", EstadoPedido.ENVIADO);
        this.estado = EstadoPedido.ENTREGADO;
    }

    // Una vez enviado ya no se puede cancelar.
    public void cancelar() {
        comprobarEstado("cancelar", EstadoPedido.CREADO, EstadoPedido.PAGADO);
        this.estado = EstadoPedido.CANCELADO;
    }

    // Se calcula a partir de los detalles, así nunca queda desincronizado.
    public Dinero total() {
        return detalles.stream().map(DetallePedido::subtotal).reduce(Dinero.cero(moneda), Dinero::sumar);
    }

    private DetallePedido buscar(ProductoId productoId) {
        return detalles.stream().filter(d -> d.productoId().equals(productoId)).findFirst().orElse(null);
    }

    private void comprobarMoneda(Dinero dinero) {
        if (!dinero.moneda().equals(moneda)) {
            throw new IllegalArgumentException("el pedido es en " + moneda + " y se recibió " + dinero.moneda());
        }
    }

    private void comprobarEstado(String accion, EstadoPedido... permitidos) {
        for (EstadoPedido permitido : permitidos) {
            if (estado == permitido) {
                return;
            }
        }
        throw new IllegalStateException("no se puede " + accion + " con el pedido en estado " + estado);
    }

    public PedidoId id() {
        return id;
    }

    public ClienteId clienteId() {
        return clienteId;
    }

    public LocalDate fechaCreacion() {
        return fechaCreacion;
    }

    public Currency moneda() {
        return moneda;
    }

    public Direccion direccionEnvio() {
        return direccionEnvio;
    }

    public EstadoPedido estado() {
        return estado;
    }

    // Copia inmutable: los detalles solo se modifican a través de los métodos del pedido.
    public List<DetallePedido> detalles() {
        return List.copyOf(detalles);
    }

    // Igualdad por identidad, igual que en Cliente y Producto.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido otro)) return false;
        return id.equals(otro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Pedido " + id;
    }
}
