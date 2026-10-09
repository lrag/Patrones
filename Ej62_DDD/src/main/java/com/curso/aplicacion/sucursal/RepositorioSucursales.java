package com.curso.aplicacion.sucursal;

import com.curso.dominio.entidad.sucursal.Sucursal;
import com.curso.dominio.vo.Direccion;
import com.curso.dominio.vo.Distancia;
import java.util.Optional;

public interface RepositorioSucursales {

    // La implementación se apoya en una base de datos geográfica: devuelve la sucursal física
    // más cercana a la dirección dentro del radio, o vacío si no hay ninguna.
    Optional<Sucursal> masCercanaA(Direccion direccion, Distancia radio);

    // La sucursal online, que es única y especial.
    Sucursal online();
}
