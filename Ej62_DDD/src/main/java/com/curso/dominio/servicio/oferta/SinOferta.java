package com.curso.dominio.servicio.oferta;

import java.util.List;

import com.curso.dominio.entidad.factura.LineaFactura;

public final class SinOferta implements Oferta {

    @Override
    public List<LineaFactura> aplicar(List<LineaFactura> lineas) {
        return lineas;
    }
}
