package com.curso.dominio.entidad.factura;

import com.curso.dominio.entidad.cliente.ClienteId;
import com.curso.dominio.entidad.pedido.PedidoId;
import com.curso.dominio.vo.Dinero;
import java.time.LocalDate;
import java.util.Currency;
import java.util.List;
import java.util.Objects;

/*

Qué garantiza y qué no garantiza el agregado Factura:

GARANTIZA

Es inmutable una vez emitida.
    No tiene ningún método que la modifique: todos sus campos son finales
    y lineas() devuelve una copia inmutable.

Tiene al menos una línea.
    Una factura sin líneas no existe.

Una única moneda.
    Todas las líneas están en la misma moneda, y los totales se expresan en ella.

Líneas coherentes.
    Cada línea tiene precio y descuento no negativos, y el descuento no supera su importe.

Totales correctos.
    No se guardan: se calculan a partir de las líneas.

Datos obligatorios siempre presentes.
    Id, pedido, cliente, fecha de emisión y líneas nunca son nulos.

NO GARANTIZA

Que el pedido exista ni que la factura se corresponda con él.
    Solo guarda un PedidoId; no sabe si los importes coinciden con los del pedido.

Que un pedido se facture una sola vez.
    Tendría que consultar las demás facturas.

Que el descuento sea el que corresponde a las ofertas vigentes.
    Recibe las líneas ya calculadas.

Que el cliente exista.
    Solo guarda un ClienteId.

Numeración correlativa.
    Un número de factura legal necesita una secuencia externa.

Que la fecha de emisión tenga sentido.
    Se recibe por parámetro y puede ser futura.


*/
public class Factura {

    private final FacturaId id;
    // Pedido y Cliente son otros agregados: se referencian solo por su id.
    private final PedidoId pedidoId;
    private final ClienteId clienteId;
    private final LocalDate fechaEmision;
    private final List<LineaFactura> lineas;

    private Factura(FacturaId id, PedidoId pedidoId, ClienteId clienteId, LocalDate fechaEmision,
                    List<LineaFactura> lineas) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.clienteId = clienteId;
        this.fechaEmision = fechaEmision;
        this.lineas = lineas;
    }

    // Reconstruye una factura existente.
    public static Factura of(FacturaId id, PedidoId pedidoId, ClienteId clienteId, LocalDate fechaEmision,
                             List<LineaFactura> lineas) {
        if (id == null) {
            throw new IllegalArgumentException("el id de la factura no puede ser nulo");
        }
        if (pedidoId == null) {
            throw new IllegalArgumentException("el pedido de la factura no puede ser nulo");
        }
        if (clienteId == null) {
            throw new IllegalArgumentException("el cliente de la factura no puede ser nulo");
        }
        if (fechaEmision == null) {
            throw new IllegalArgumentException("la fecha de emisión de la factura no puede ser nula");
        }
        if (lineas == null) {
            throw new IllegalArgumentException("las líneas de la factura no pueden ser nulas");
        }
        if (lineas.isEmpty()) {
            throw new IllegalArgumentException("una factura debe tener al menos una línea");
        }
        List<LineaFactura> copia = List.copyOf(lineas);
        Currency moneda = copia.get(0).precioUnitario().moneda();
        for (LineaFactura linea : copia) {
            if (!linea.precioUnitario().moneda().equals(moneda)) {
                throw new IllegalArgumentException("todas las líneas deben estar en " + moneda);
            }
        }
        return new Factura(id, pedidoId, clienteId, fechaEmision, copia);
    }

    // Emite una factura nueva, con una identidad recién generada.
    public static Factura emitir(PedidoId pedidoId, ClienteId clienteId, LocalDate fechaEmision,
                                 List<LineaFactura> lineas) {
        return of(FacturaId.nuevo(), pedidoId, clienteId, fechaEmision, lineas);
    }

    // Se calculan a partir de las líneas, así nunca quedan desincronizados.
    public Dinero totalBruto() {
        return lineas.stream().map(LineaFactura::importeBruto).reduce(Dinero.cero(moneda()), Dinero::sumar);
    }

    public Dinero totalDescuentos() {
        return lineas.stream().map(LineaFactura::descuento).reduce(Dinero.cero(moneda()), Dinero::sumar);
    }

    public Dinero total() {
        return lineas.stream().map(LineaFactura::importeNeto).reduce(Dinero.cero(moneda()), Dinero::sumar);
    }

    public Currency moneda() {
        return lineas.get(0).precioUnitario().moneda();
    }

    public FacturaId id() {
        return id;
    }

    public PedidoId pedidoId() {
        return pedidoId;
    }

    public ClienteId clienteId() {
        return clienteId;
    }

    public LocalDate fechaEmision() {
        return fechaEmision;
    }

    public List<LineaFactura> lineas() {
        return lineas;
    }

    // Igualdad por identidad, igual que en el resto de raíces.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Factura otra)) return false;
        return id.equals(otra.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Factura " + id;
    }
}
