package com.curso.dominio.entidad.comercial;

import com.curso.dominio.entidad.sucursal.SucursalId;
import com.curso.dominio.vo.CorreoElectronico;
import com.curso.dominio.vo.Nombre;
import java.util.Objects;

/*

Qué garantiza y qué no garantiza el agregado Comercial:

GARANTIZA

Datos obligatorios siempre presentes y válidos.
    Id, nombre, correo y sucursal nunca son nulos, ni al crear ni al cambiarlos.
    El id no cambia nunca.

Cambios con significado.
    La sucursal solo cambia con trasladarA, y el correo con cambiarCorreo.

Identidad estable.
    equals y hashCode dependen solo del id.

NO GARANTIZA

Que la sucursal exista.
    Solo guarda un SucursalId.

Que el correo sea único.
    Tendría que consultar el repositorio.

Que tenga capacidad para más clientes.
    No conoce su cartera de clientes.

Concurrencia y autorización.
    No lleva versión ni sabe quién puede modificarlo.

*/
public class Comercial {

    private final ComercialId id;
    private final Nombre nombre;
    private CorreoElectronico correo;
    // Sucursal es otro agregado: se referencia solo por su id.
    private SucursalId sucursalId;

    private Comercial(ComercialId id, Nombre nombre, CorreoElectronico correo, SucursalId sucursalId) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.sucursalId = sucursalId;
    }

    // Reconstruye un comercial existente.
    public static Comercial of(ComercialId id, Nombre nombre, CorreoElectronico correo, SucursalId sucursalId) {
        if (id == null) {
            throw new IllegalArgumentException("el id del comercial no puede ser nulo");
        }
        if (nombre == null) {
            throw new IllegalArgumentException("el nombre del comercial no puede ser nulo");
        }
        if (correo == null) {
            throw new IllegalArgumentException("el correo del comercial no puede ser nulo");
        }
        if (sucursalId == null) {
            throw new IllegalArgumentException("la sucursal del comercial no puede ser nula");
        }
        return new Comercial(id, nombre, correo, sucursalId);
    }

    // Da de alta a un comercial nuevo, con una identidad recién generada.
    public static Comercial incorporar(Nombre nombre, CorreoElectronico correo, SucursalId sucursalId) {
        return of(ComercialId.nuevo(), nombre, correo, sucursalId);
    }

    public void trasladarA(SucursalId nuevaSucursal) {
        if (nuevaSucursal == null) {
            throw new IllegalArgumentException("la sucursal del comercial no puede ser nula");
        }
        this.sucursalId = nuevaSucursal;
    }

    public void cambiarCorreo(CorreoElectronico nuevo) {
        if (nuevo == null) {
            throw new IllegalArgumentException("el correo del comercial no puede ser nulo");
        }
        this.correo = nuevo;
    }

    public ComercialId id() {
        return id;
    }

    public Nombre nombre() {
        return nombre;
    }

    public CorreoElectronico correo() {
        return correo;
    }

    public SucursalId sucursalId() {
        return sucursalId;
    }

    // Igualdad por identidad, igual que en el resto de raíces.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comercial otro)) return false;
        return id.equals(otro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Comercial " + id;
    }
}
