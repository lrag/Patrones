package com.curso.dominio.entidad.sucursal;

import com.curso.dominio.vo.Direccion;
import com.curso.dominio.vo.Distancia;
import java.util.Objects;
import java.util.Optional;

/*

Qué garantiza y qué no garantiza el agregado Sucursal:

GARANTIZA

Datos obligatorios siempre presentes.
    Id, nombre (no vacío, hasta 100 caracteres) y tipo nunca son nulos.
    El id y el tipo no cambian nunca.

Dirección coherente con el tipo.
    Una sucursal física siempre tiene dirección.
    La online nunca la tiene.

Identidad estable.
    equals y hashCode dependen solo del id.

NO GARANTIZA

Que solo haya una sucursal online.
    Tendría que consultar las demás sucursales.

Que el nombre sea único.
    Lo mismo.

Que la dirección exista ni su ubicación geográfica.
    Es un dato que recibe.

Concurrencia y autorización.
    No lleva versión ni sabe quién puede modificarla.

*/
public class Sucursal {

    // Regla de negocio: a un cliente se le asigna la sucursal física más cercana dentro de este radio.
    public static final Distancia RADIO_DE_COBERTURA = Distancia.of(5, Distancia.Unidad.KILOMETRO);

    private static final int NOMBRE_MAXIMO = 100;

    private final SucursalId id;
    private final TipoSucursal tipo;
    private String nombre;
    // Solo las sucursales físicas tienen dirección.
    private final Direccion direccion;

    private Sucursal(SucursalId id, TipoSucursal tipo, String nombre, Direccion direccion) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    // Reconstruye una sucursal existente.
    public static Sucursal of(SucursalId id, String nombre, TipoSucursal tipo, Direccion direccion) {
        if (id == null) {
            throw new IllegalArgumentException("el id de la sucursal no puede ser nulo");
        }
        if (tipo == null) {
            throw new IllegalArgumentException("el tipo de la sucursal no puede ser nulo");
        }
        if (tipo == TipoSucursal.FISICA && direccion == null) {
            throw new IllegalArgumentException("una sucursal física necesita dirección");
        }
        if (tipo == TipoSucursal.ONLINE && direccion != null) {
            throw new IllegalArgumentException("una sucursal online no tiene dirección");
        }
        return new Sucursal(id, tipo, normalizarNombre(nombre), direccion);
    }

    public static Sucursal abrirFisica(String nombre, Direccion direccion) {
        return of(SucursalId.nuevo(), nombre, TipoSucursal.FISICA, direccion);
    }

    public static Sucursal abrirOnline(String nombre) {
        return of(SucursalId.nuevo(), nombre, TipoSucursal.ONLINE, null);
    }

    public void cambiarNombre(String nuevo) {
        this.nombre = normalizarNombre(nuevo);
    }

    public boolean esOnline() {
        return tipo == TipoSucursal.ONLINE;
    }

    private static String normalizarNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("el nombre de la sucursal no puede estar en blanco");
        }
        String normalizado = nombre.strip();
        if (normalizado.length() > NOMBRE_MAXIMO) {
            throw new IllegalArgumentException(
                    "el nombre de la sucursal no puede superar " + NOMBRE_MAXIMO + " caracteres");
        }
        return normalizado;
    }

    public SucursalId id() {
        return id;
    }

    public TipoSucursal tipo() {
        return tipo;
    }

    public String nombre() {
        return nombre;
    }

    public Optional<Direccion> direccion() {
        return Optional.ofNullable(direccion);
    }

    // Igualdad por identidad, igual que en el resto de raíces.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sucursal otra)) return false;
        return id.equals(otra.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Sucursal " + id;
    }
}
