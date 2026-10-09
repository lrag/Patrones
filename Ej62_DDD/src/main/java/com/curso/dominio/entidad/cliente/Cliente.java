package com.curso.dominio.entidad.cliente;

import com.curso.dominio.entidad.comercial.ComercialId;
import com.curso.dominio.entidad.sucursal.SucursalId;
import com.curso.dominio.vo.CorreoElectronico;
import com.curso.dominio.vo.Direccion;
import com.curso.dominio.vo.Nombre;
import com.curso.dominio.vo.Telefono;
import java.time.LocalDate;
import java.util.Objects;

/*

Qué garantiza y qué no garantiza el agregado Cliente:

GARANTIZA

Datos obligatorios siempre presentes y válidos.
    Nombre, dirección, correo y teléfono nunca son nulos, ni al crear ni al cambiarlos,
    y al ser Value Objects ya llegan validados.

Cartera siempre asignada.
    Siempre tiene una sucursal y un comercial, que solo cambian con reasignarCartera.

Identidad inmutable.
    El id y la fecha de alta no cambian nunca.

Observaciones bien formadas.
    Nunca son nulas (sin observaciones es una cadena vacía),
    se les quitan los espacios de los extremos y no superan 500 caracteres.

Cambios con significado.
    Los datos solo se modifican con las operaciones cambiarNombre, cambiarDireccion,
    cambiarCorreo, cambiarTelefono y cambiarObservaciones, que comprueban sus reglas.

Identidad estable.
    equals y hashCode dependen solo del id, así que cambiar los datos no cambia quién es el cliente.

NO GARANTIZA

Que el correo sea único.
    Dos clientes pueden tener el mismo CorreoElectronico; hace falta consultar el repositorio.

Que el cliente no esté duplicado.
    Nada impide registrar dos veces a la misma persona.

Que el correo o el teléfono sean reales ni pertenezcan al cliente.
    Solo se valida el formato; la verificación es externa.

Que la dirección exista.
    No se comprueba que la calle exista ni que el código postal corresponda a la ciudad y al país.

Que la cartera sea correcta.
    No sabe si la sucursal y el comercial existen, ni que el comercial trabaje en esa sucursal,
    ni que sean los que corresponden a su dirección.

Que la fecha de alta tenga sentido.
    Se recibe por parámetro y puede ser futura.

Quién puede modificar al cliente.
    No hay autorización.

Concurrencia.
    No lleva versión: dos cambios simultáneos pueden pisarse.

*/
public class Cliente {

    private static final int OBSERVACIONES_MAXIMAS = 500;

    private final ClienteId id;
    //LocalDate es un VO que viene en el api de Java
    private final LocalDate fechaAlta;
    private Nombre nombre;
    private Direccion direccion;
    private CorreoElectronico correo;
    private Telefono telefono;
    private String observaciones;
    // Sucursal y Comercial son otros agregados: se referencian solo por su id.
    private SucursalId sucursalId;
    private ComercialId comercialId;

    private Cliente(ClienteId id, LocalDate fechaAlta, Nombre nombre, Direccion direccion,
                    CorreoElectronico correo, Telefono telefono, String observaciones,
                    SucursalId sucursalId, ComercialId comercialId) {
        this.id = id;
        this.fechaAlta = fechaAlta;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.observaciones = observaciones;
        this.sucursalId = sucursalId;
        this.comercialId = comercialId;
    }

    // Reconstruye un cliente existente. Las observaciones son opcionales: null equivale a "sin observaciones".
    public static Cliente of(ClienteId id, LocalDate fechaAlta, Nombre nombre, Direccion direccion,
                             CorreoElectronico correo, Telefono telefono, String observaciones,
                             SucursalId sucursalId, ComercialId comercialId) {
        if (id == null) {
            throw new IllegalArgumentException("el id del cliente no puede ser nulo");
        }
        if (fechaAlta == null) {
            throw new IllegalArgumentException("la fecha de alta del cliente no puede ser nula");
        }
        if (nombre == null) {
            throw new IllegalArgumentException("el nombre del cliente no puede ser nulo");
        }
        if (direccion == null) {
            throw new IllegalArgumentException("la dirección del cliente no puede ser nula");
        }
        if (correo == null) {
            throw new IllegalArgumentException("el correo del cliente no puede ser nulo");
        }
        if (telefono == null) {
            throw new IllegalArgumentException("el teléfono del cliente no puede ser nulo");
        }
        if (sucursalId == null) {
            throw new IllegalArgumentException("la sucursal del cliente no puede ser nula");
        }
        if (comercialId == null) {
            throw new IllegalArgumentException("el comercial del cliente no puede ser nulo");
        }
        return new Cliente(id, fechaAlta, nombre, direccion, correo, telefono, normalizarObservaciones(observaciones),
                sucursalId, comercialId);
    }

    // Da de alta un cliente nuevo, con una identidad recién generada y sin observaciones.
    public static Cliente registrar(LocalDate fechaAlta, Nombre nombre, Direccion direccion,
                                    CorreoElectronico correo, Telefono telefono,
                                    SucursalId sucursalId, ComercialId comercialId) {
        return of(ClienteId.nuevo(), fechaAlta, nombre, direccion, correo, telefono, null, sucursalId, comercialId);
    }

    public void reasignarCartera(SucursalId nuevaSucursal, ComercialId nuevoComercial) {
        if (nuevaSucursal == null) {
            throw new IllegalArgumentException("la sucursal del cliente no puede ser nula");
        }
        if (nuevoComercial == null) {
            throw new IllegalArgumentException("el comercial del cliente no puede ser nulo");
        }
        this.sucursalId = nuevaSucursal;
        this.comercialId = nuevoComercial;
    }

    public void cambiarNombre(Nombre nuevo) {
        if (nuevo == null) {
            throw new IllegalArgumentException("el nombre del cliente no puede ser nulo");
        }
        this.nombre = nuevo;
    }

    public void cambiarDireccion(Direccion nueva) {
        if (nueva == null) {
            throw new IllegalArgumentException("la dirección del cliente no puede ser nula");
        }
        this.direccion = nueva;
    }

    public void cambiarCorreo(CorreoElectronico nuevo) {
        if (nuevo == null) {
            throw new IllegalArgumentException("el correo del cliente no puede ser nulo");
        }
        this.correo = nuevo;
    }

    public void cambiarTelefono(Telefono nuevo) {
        if (nuevo == null) {
            throw new IllegalArgumentException("el teléfono del cliente no puede ser nulo");
        }
        this.telefono = nuevo;
    }

    public void cambiarObservaciones(String nuevas) {
        this.observaciones = normalizarObservaciones(nuevas);
    }

    private static String normalizarObservaciones(String observaciones) {
        if (observaciones == null) {
            return "";
        }
        String normalizadas = observaciones.strip();
        if (normalizadas.length() > OBSERVACIONES_MAXIMAS) {
            throw new IllegalArgumentException(
                    "las observaciones no pueden superar " + OBSERVACIONES_MAXIMAS + " caracteres");
        }
        return normalizadas;
    }

    public ClienteId id() {
        return id;
    }

    public LocalDate fechaAlta() {
        return fechaAlta;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Direccion direccion() {
        return direccion;
    }

    public CorreoElectronico correo() {
        return correo;
    }

    public Telefono telefono() {
        return telefono;
    }

    public String observaciones() {
        return observaciones;
    }

    public SucursalId sucursalId() {
        return sucursalId;
    }

    public ComercialId comercialId() {
        return comercialId;
    }

    // Igualdad por identidad: dos referencias al mismo cliente son iguales aunque sus datos hayan cambiado.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente otro)) return false;
        return id.equals(otro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cliente " + id;
    }
}
