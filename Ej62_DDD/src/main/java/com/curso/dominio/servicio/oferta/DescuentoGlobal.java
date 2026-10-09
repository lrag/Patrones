package com.curso.dominio.servicio.oferta;

import com.curso.dominio.entidad.factura.LineaFactura;
import com.curso.dominio.vo.Porcentaje;
import java.util.List;

// Un porcentaje de descuento sobre todas las líneas. Se calcula línea a línea, así que el redondeo
// de cada una puede diferir en algún céntimo del que resultaría aplicándolo al total.
public final class DescuentoGlobal implements Oferta {

    private final Porcentaje porcentaje;

    public DescuentoGlobal(Porcentaje porcentaje) {
        if (porcentaje == null) {
            throw new IllegalArgumentException("el porcentaje no puede ser nulo");
        }
        this.porcentaje = porcentaje;
    }

    @Override
    public List<LineaFactura> aplicar(List<LineaFactura> lineas) {
        return lineas.stream()
                .map(linea -> linea.conDescuentoAdicional(porcentaje.aplicarA(linea.importeNeto())))
                .toList();
    }
}
