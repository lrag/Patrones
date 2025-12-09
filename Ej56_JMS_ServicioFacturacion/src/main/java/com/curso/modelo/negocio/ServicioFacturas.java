package com.curso.modelo.negocio;

import com.curso.modelo.entidad.Factura;
import com.curso.modelo.entidad.Pedido;

public interface ServicioFacturas {

	Factura facturarPedido(Pedido pedido);

}