package com.curso.dominio.entidad.producto;

import com.curso.dominio.vo.Dinero;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



/*
Entidad raíz

Tiene identidad.
    Se distingue por su id, no por sus atributos.
    El id se asigna al crearla y no cambia nunca.

Igualdad por identidad.
    equals y hashCode se basan solo en el id.
    Dos instancias con el mismo id son la misma entidad aunque sus datos difieran.

Tiene ciclo de vida.
    Se crea, cambia a lo largo del tiempo y puede desaparecer.
    A diferencia de un VO, es mutable.

Siempre es válida.
    Sus invariantes se comprueban al crearla y en cada cambio.
    Nunca queda en un estado incoherente.

Se modifica con operaciones del negocio.
    Los métodos se llaman como en el lenguaje ubicuo (cambiarDireccion, trasladarA),
    no con setters automáticos.
    Cada operación puede contener las reglas asociadas.

Protege su estado (le encapsulamiento).
    No expone colecciones modificables (devuelve copias inmutables).
    Solo se cambia a través de sus propios métodos.

Se compone de VOs.
    Sus atributos con significado propio (Direccion, CorreoElectronico, Dinero)
    son Value Objects.
    No es obligatorio que todo en una entidad sea VO

Referencia a otros agregados solo por id.
    Nunca guarda el objeto de otro agregado.

Es un límite de consistencia y de transacción.
    Lo que contiene se guarda y se modifica junto, en una sola transacción.

Tiene su propio repositorio.
    Se carga y se guarda por su id.
    Desde fuera del agregado se obtiene siempre a través de su repositorio,
    y no navegando desde otros objetos (si ya existiera, si es nueva se llega
    a ella creandola)

Tiene un modo de creación controlado.
    Constructor privado y fábricas (registrar para altas nuevas, of para reconstruir).

Es independiente de la infraestructura.
    No conoce bases de datos, frameworks ni servicios externos.
*/    




/*

Qué garantiza y qué no garantiza el agregado Producto:

GARANTIZA

Datos obligatorios siempre presentes.
    Id, fecha de alta, nombre, fabricante y precio nunca son nulos ni vacíos.
    El id y la fecha de alta no cambian nunca.

Nombre bien formado.
    Se le quitan los espacios de los extremos y no supera 100 caracteres.

Precio válido.
    Nunca es negativo, y al ser un Dinero siempre lleva su moneda.

Fabricante válido.
    Al ser un Value Object, siempre tiene nombre y país correctos.

Sin características duplicadas.
    No puede haber dos con el mismo nombre (sin distinguir mayúsculas).
    No se puede quitar una característica que no existe.

Estado interno protegido.
    caracteristicas() devuelve una copia inmutable, y la lista recibida al reconstruir no queda compartida.
    Solo se modifica con addCaracteristica y quitarCaracteristica.

Identidad estable.
    equals y hashCode dependen solo del id, así que cambiar los datos no cambia qué producto es.

NO GARANTIZA

Que el producto sea único.
    Nada impide dos productos con el mismo nombre o el mismo código.

Que el fabricante sea real.
    Es un Value Object sin catálogo detrás: acepta cualquier nombre y país.

Que las características sean coherentes.
    No sabe cuáles son obligatorias o válidas para cada tipo de producto.

Que se pueda vender.
    No tiene stock, así que no conoce su disponibilidad.

Que el precio sea el vigente o esté en la moneda que se necesita.
    Guarda un único precio y no historial, ofertas ni precios por moneda.

Que la fecha de alta tenga sentido.
    Se recibe por parámetro y puede ser futura.

Quién puede modificar el producto.
    No hay autorización.

Concurrencia.
    No lleva versión: dos cambios simultáneos pueden pisarse.

*/
public class Producto {

    private static final int NOMBRE_MAXIMO = 100;

    private final ProductoId id;
    private final LocalDate fechaAlta;
    //El nombre aquí no es un VO. Producto se encargará de que sea correcto
    private String nombre;
    private Fabricante fabricante;
    private Dinero precio;
    private final List<Caracteristica> caracteristicas;

    private Producto(ProductoId id, LocalDate fechaAlta, String nombre, Fabricante fabricante, Dinero precio,
                     List<Caracteristica> caracteristicas) {
        this.id = id;
        this.fechaAlta = fechaAlta;
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.precio = precio;
        this.caracteristicas = caracteristicas;
    }

    // Reconstruye un producto existente. Las características son opcionales: null equivale a "sin características".
    public static Producto of(ProductoId id, LocalDate fechaAlta, String nombre, Fabricante fabricante, Dinero precio,
                              List<Caracteristica> caracteristicas) {
        if (id == null) {
            throw new IllegalArgumentException("el id del producto no puede ser nulo");
        }
        if (fechaAlta == null) {
            throw new IllegalArgumentException("la fecha de alta del producto no puede ser nula");
        }
        if (fabricante == null) {
            throw new IllegalArgumentException("el fabricante del producto no puede ser nulo");
        }
        comprobarPrecio(precio);
        Producto producto = new Producto(id, fechaAlta, normalizarNombre(nombre), fabricante, precio,
                new ArrayList<>());
        if (caracteristicas != null) {
            caracteristicas.forEach(producto::addCaracteristica);
        }
        return producto;
    }

    // Da de alta un producto nuevo, con una identidad recién generada y sin características.
    public static Producto registrar(LocalDate fechaAlta, String nombre, Fabricante fabricante, Dinero precio) {
        return of(ProductoId.nuevo(), fechaAlta, nombre, fabricante, precio, null);
    }

    public void cambiarPrecio(Dinero nuevo) {
        comprobarPrecio(nuevo);
        this.precio = nuevo;
    }

    private static void comprobarPrecio(Dinero precio) {
        if (precio == null) {
            throw new IllegalArgumentException("el precio del producto no puede ser nulo");
        }
        if (precio.esNegativo()) {
            throw new IllegalArgumentException("el precio del producto no puede ser negativo: " + precio);
        }
    }

    public void cambiarNombre(String nuevo) {
        this.nombre = normalizarNombre(nuevo);
    }

    public void cambiarFabricante(Fabricante nuevo) {
        if (nuevo == null) {
            throw new IllegalArgumentException("el fabricante del producto no puede ser nulo");
        }
        this.fabricante = nuevo;
    }

    // Un producto tiene como mucho una característica con un nombre dado (no dos "Color").
    public void addCaracteristica(Caracteristica caracteristica) {
        if (caracteristica == null) {
            throw new IllegalArgumentException("la característica del producto no puede ser nula");
        }
        if (buscar(caracteristica.nombre()) != null) {
            throw new IllegalArgumentException(
                    "el producto ya tiene una característica llamada " + caracteristica.nombre());
        }
        caracteristicas.add(caracteristica);
    }

    public void quitarCaracteristica(String nombreCaracteristica) {
        Caracteristica existente = buscar(nombreCaracteristica);
        if (existente == null) {
            throw new IllegalArgumentException("el producto no tiene una característica llamada " + nombreCaracteristica);
        }
        caracteristicas.remove(existente);
    }

    private Caracteristica buscar(String nombreCaracteristica) {
        return caracteristicas.stream()
                .filter(c -> c.nombre().equalsIgnoreCase(nombreCaracteristica))
                .findFirst()
                .orElse(null);
    }

    private static String normalizarNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("el nombre del producto no puede estar en blanco");
        }
        String normalizado = nombre.strip();
        if (normalizado.length() > NOMBRE_MAXIMO) {
            throw new IllegalArgumentException("el nombre del producto no puede superar " + NOMBRE_MAXIMO + " caracteres");
        }
        return normalizado;
    }

    public ProductoId id() {
        return id;
    }

    public LocalDate fechaAlta() {
        return fechaAlta;
    }

    public String nombre() {
        return nombre;
    }

    public Fabricante fabricante() {
        return fabricante;
    }

    public Dinero precio() {
        return precio;
    }

    // Copia inmutable: la lista solo se modifica a través de los métodos del producto.
    public List<Caracteristica> caracteristicas() {
        return List.copyOf(caracteristicas);
    }

    // Igualdad por identidad, igual que en Cliente.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto otro)) return false;
        return id.equals(otro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Producto " + id;
    }
}
