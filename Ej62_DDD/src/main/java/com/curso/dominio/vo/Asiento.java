package com.curso.dominio.vo;

import java.util.Objects;

/*

Value Object:

Sin identidad. 
    Se define solo por sus atributos. 
    Dos VOs con los mismos valores son intercambiables 
        Asiento 12C es siempre el mismo asiento.
        Las direcciones ya existen.
        Un correo no puede modificarse.
Igualdad por valor. 
    equals y hashCode se basan en todos los atributos, 
    y no en la referencia ni en un id.

Inmutable. 
    Una vez creado no cambia. 
    Los campos son final, no hay setters, y las operaciones (sumar, restar) 
    devuelven una instancia nueva.

Siempre válido. 
    Las invariantes se comprueban al crearlo, de modo que si existe, es válido. 
    Nunca hay un estado intermedio inválido.

Autovalidado. 
    Cada VO conoce y aplica sus propias reglas, sin depender de que el código
    que lo usa las compruebe.

Cohesivo. Agrupa atributos que forman un concepto único 
    (importe + moneda, calle + ciudad + código postal + país) y no 
    tienen sentido por separado.

Con comportamiento propio. 
    No son anémicos.
    No es un simple contenedor de datos. 
    Lleva la lógica relacionada con su concepto (Dinero.sumar, Porcentaje.aplicarA, 
    conversiones de unidades).

Operaciones sin efectos secundarios. 
    Las funciones son puras y devuelven un resultado y no modifican el objeto ni nada fuera de él.

Intercambiable y sustituible. 
    Se puede reemplazar por otra instancia igual sin que cambie nada. 
    Por eso se puede compartir y copiar con libertad.

Sin ciclo de vida. 
    No se crea, modifica o elimina a lo largo del tiempo: se crea y se descarta, 
    y solo existe dentro de otros objetos (entidades o agregados).

Expresa el lenguaje ubicuo. 
    Da nombre de dominio a un concepto (CorreoElectronico en lugar de String), lo 
    que hace el modelo más legible y evita errores de tipo.
*/

/*

VO vs DTO

Se parecen por fuera (campos, igualdad por valor, sin identidad)
    ->tienen propósitos distintos.

Propósito.
    VO: modela un concepto del dominio (Asiento, Dinero, Direccion).
    DTO: transporta datos entre capas o entre procesos (de la API a la aplicación, a la base de datos...).

Capa.
    VO: vive en el dominio.
    DTO: vive en la frontera (presentación, aplicación, infraestructura). El dominio no lo conoce.

Comportamiento.
    VO: lleva la lógica de su concepto (Dinero.sumar, Porcentaje.aplicarA, conversiones de unidades).
    DTO: solo datos, sin lógica de negocio.

Validación.
    VO: siempre es válido; sus invariantes se comprueban al crearlo.
    DTO: puede contener datos crudos o inválidos; es el dato tal como llega.

Inmutabilidad.
    VO: siempre inmutable.
    DTO: puede ser mutable (getters y setters, JavaBeans), según lo que pida el framework.

Igualdad.
    VO: por valor, y forma parte de su significado.
    DTO: normalmente no tiene semántica de igualdad; si la tiene, es incidental.

Tipos.
    VO: usa tipos del dominio (un Dinero, no un double y un String sueltos).
    DTO: usa tipos simples y serializables (String, int, listas), pensados para JSON, formularios o filas.

Lenguaje.
    VO: expresa el lenguaje ubicuo.
    DTO: refleja el formato de transporte (el contrato de una API, una pantalla, una tabla).

Dependencias.
    VO: sin frameworks ni anotaciones técnicas.
    DTO: puede llevar anotaciones de serialización o de validación de entrada.

Granularidad.
    VO: un concepto cohesivo con sentido por sí mismo.
    DTO: lo que necesita una operación o una pantalla, aunque mezcle datos de varios agregados.

Motivo de cambio.
    VO: cambia cuando cambia una regla del negocio.
    DTO: cambia cuando cambia el contrato de la API o la pantalla.

Relación entre ambos.
    El DTO se convierte en VO en el borde de la aplicación, y es ahí donde se validan los datos.
    El VO nunca viaja tal cual por la API: se convierte de nuevo en DTO para salir.

*/



public final class Asiento {

    private static final char LETRA_MINIMA = 'A';
    private static final char LETRA_MAXIMA = 'K';

    private final int fila;
    private final char letra;

    private Asiento(int fila, char letra) {
        this.fila = fila;
        this.letra = letra;
    }

    public static Asiento of(int fila, char letra) {
        if (fila <= 0) {
            throw new IllegalArgumentException("la fila debe ser mayor que cero: " + fila);
        }
        char letraNormalizada = Character.toUpperCase(letra);
        if (letraNormalizada < LETRA_MINIMA || letraNormalizada > LETRA_MAXIMA) {
            throw new IllegalArgumentException(
                    "la letra debe estar entre " + LETRA_MINIMA + " y " + LETRA_MAXIMA + ": " + letra);
        }
        return new Asiento(fila, letraNormalizada);
    }

    //Crea un asiento a partir del código de la tarjeta de embarque, ej. "12C". 
    public static Asiento of(String codigo) {
        if (codigo == null || codigo.length() < 2) {
            throw new IllegalArgumentException("código de asiento no válido: " + codigo);
        }
        String parteFila = codigo.substring(0, codigo.length() - 1);
        char letra = codigo.charAt(codigo.length() - 1);
        try {
            return of(Integer.parseInt(parteFila), letra);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("código de asiento no válido: " + codigo, e);
        }
    }

    public int fila() {
        return fila;
    }

    public char letra() {
        return letra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Asiento otro)) return false;
        return fila == otro.fila && letra == otro.letra;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fila, letra);
    }

    @Override
    public String toString() {
        return fila + String.valueOf(letra);
    }
}
