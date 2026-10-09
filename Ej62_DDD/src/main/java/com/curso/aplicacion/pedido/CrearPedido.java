package com.curso.aplicacion.pedido;

import com.curso.aplicacion.cliente.ClienteNoEncontradoException;
import com.curso.aplicacion.cliente.RepositorioClientes;
import com.curso.aplicacion.producto.ProductoNoEncontradoException;
import com.curso.aplicacion.producto.RepositorioProductos;
import com.curso.dominio.entidad.cliente.Cliente;
import com.curso.dominio.entidad.cliente.ClienteId;
import com.curso.dominio.entidad.pedido.Pedido;
import com.curso.dominio.entidad.pedido.PedidoId;
import com.curso.dominio.entidad.producto.Cantidad;
import com.curso.dominio.entidad.producto.Producto;
import com.curso.dominio.entidad.producto.ProductoId;

import java.time.Clock;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

// Servicio de aplicación del caso de uso "crear pedido": comprueba que el cliente y los productos existen,
// y le da al Pedido los datos que necesita (nombre y precio de cada producto, dirección del cliente).
// El Pedido es el que aplica sus reglas; aquí solo se orquesta.
public class CrearPedido {

    private final RepositorioClientes clientes;
    private final RepositorioProductos productos;
    private final RepositorioPedidos pedidos;
    private final Clock reloj;

    public CrearPedido(RepositorioClientes clientes, RepositorioProductos productos, RepositorioPedidos pedidos) {
        this(clientes, productos, pedidos, Clock.systemDefaultZone());
    }

    public CrearPedido(RepositorioClientes clientes, RepositorioProductos productos, RepositorioPedidos pedidos,
                       Clock reloj) {
        this.clientes = clientes;
        this.productos = productos;
        this.pedidos = pedidos;
        this.reloj = reloj;
    }

    public PedidoId ejecutar(CrearPedidoComando comando) {
        if (comando == null) {
            throw new IllegalArgumentException("el comando no puede ser nulo");
        }

        // Del DTO a los Value Objects: se valida todo antes de consultar nada.
        ClienteId clienteId = ClienteId.of(comando.clienteId());
        Currency moneda = convertirMoneda(comando.moneda());
        List<LineaSolicitada> lineas = convertirLineas(comando.lineas());

        Cliente cliente = clientes.buscarPorId(clienteId).orElseThrow(() -> new ClienteNoEncontradoException(clienteId));

        //repositorioDirecciones.buscarDireccion(direccion)
        
        // La dirección de envío es una copia de la que tiene el cliente ahora.
        Pedido pedido = Pedido.registrar(clienteId, LocalDate.now(reloj), moneda, cliente.direccion());
        for (LineaSolicitada linea : lineas) {
            Producto producto = productos.buscarPorId(linea.productoId())
                    .orElseThrow(() -> new ProductoNoEncontradoException(linea.productoId()));
            //
            //Aqui se utiliza la lógica de negocio que hay en la clase Pedido para añadir los productos
            //
            pedido.addProducto(producto.id(), producto.nombre(), producto.precio(), linea.cantidad());
        }

        pedidos.guardar(pedido);
        return pedido.id();
    }

    private static Currency convertirMoneda(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("la moneda no puede estar en blanco");
        }
        return Currency.getInstance(codigo.strip().toUpperCase());
    }

    private static List<LineaSolicitada> convertirLineas(List<CrearPedidoComando.Linea> lineas) {
        if (lineas == null || lineas.isEmpty()) {
            throw new IllegalArgumentException("un pedido necesita al menos un producto");
        }
        List<LineaSolicitada> resultado = new ArrayList<>();
        for (CrearPedidoComando.Linea linea : lineas) {
            if (linea == null) {
                throw new IllegalArgumentException("la línea del pedido no puede ser nula");
            }
            resultado.add(new LineaSolicitada(ProductoId.of(linea.productoId()), Cantidad.of(linea.cantidad())));
        }
        return resultado;
    }

    private record LineaSolicitada(ProductoId productoId, Cantidad cantidad) {
    }
}
