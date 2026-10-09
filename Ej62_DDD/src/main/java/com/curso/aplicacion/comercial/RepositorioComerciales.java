package com.curso.aplicacion.comercial;

import com.curso.dominio.entidad.comercial.Comercial;
import com.curso.dominio.entidad.sucursal.SucursalId;

import java.util.Optional;

public interface RepositorioComerciales {

    // Elige un comercial de la sucursal para un cliente nuevo, o vacío si la sucursal no tiene ninguno.
    Optional<Comercial> disponibleEn(SucursalId sucursalId);
}
