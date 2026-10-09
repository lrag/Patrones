package com.curso.aplicacion.cliente;

import java.time.Clock;
import java.time.LocalDate;
import java.util.List;

import com.curso.aplicacion.comercial.RepositorioComerciales;
import com.curso.aplicacion.sucursal.RepositorioSucursales;
import com.curso.dominio.entidad.cliente.Cliente;
import com.curso.dominio.entidad.cliente.ClienteId;
import com.curso.dominio.entidad.comercial.Comercial;
import com.curso.dominio.entidad.sucursal.Sucursal;
import com.curso.dominio.vo.CorreoElectronico;
import com.curso.dominio.vo.Direccion;
import com.curso.dominio.vo.Nombre;
import com.curso.dominio.vo.Telefono;

/*

Servicio de aplicación:

Representa un caso de uso.
    Una acción completa que el sistema ofrece a quien lo usa (aquí, dar de alta a un cliente).
    Se nombra como el caso de uso, no como una entidad.

Orquesta, no decide.
    Convierte los datos de entrada, carga lo que hace falta, llama al dominio y guarda el resultado.
    Las reglas de negocio están en las entidades, los VOs y los servicios de dominio.

Es la puerta de entrada al dominio.
    Los adaptadores de entrada (una API REST, una pantalla, un proceso por lotes) llaman a este servicio,
    y nunca directamente a las entidades.

Usa los repositorios.
    Carga y guarda los agregados a través de ellos.
    Las entidades y los servicios de dominio no los conocen.

Trabaja con DTOs en la frontera.
    Recibe datos sin validar (AltaDeClienteComando) y los convierte en Value Objects,
    y es en esa conversión donde se validan.

Aplica las reglas que afectan a varios agregados o a datos externos.
    Por ejemplo, comprobar que el correo no esté ya registrado: un Cliente no puede saberlo.

Gestiona la transacción.
    Una operación del caso de uso se confirma entera o no se confirma.
    (Todavía no está implementado en este proyecto.)

No tiene estado.
    Solo guarda sus dependencias (repositorios, reloj), no datos de ninguna petición.

Depende de abstracciones.
    Recibe interfaces de repositorios, no implementaciones concretas, así que se prueba sin base de datos.

No conoce detalles técnicos.
    Ni bases de datos, ni HTTP, ni formatos de transporte: eso es infraestructura.

*/
public class AltaDeCliente {

    private final RepositorioClientes clientes;
    private final RepositorioSucursales sucursales;
    private final RepositorioComerciales comerciales;
    private final Clock reloj;

    public AltaDeCliente(
    		RepositorioClientes clientes, 
    		RepositorioSucursales sucursales,
            RepositorioComerciales comerciales
        ) {
        this(clientes, sucursales, comerciales, Clock.systemDefaultZone());
    }

    public AltaDeCliente(
    		RepositorioClientes clientes, 
    		RepositorioSucursales sucursales,
    		RepositorioComerciales comerciales, 
    		Clock reloj
    	) {
        this.clientes = clientes;
        this.sucursales = sucursales;
        this.comerciales = comerciales;
        this.reloj = reloj;
    }

    /*
    DTO			MAPPER		COMANDO_ALTA	CLIENTE
    
    -						-				id
    nombre					nombre			Nombre
    Direccion				Direccion       Direccion
    telefono				telefono        Telefoncio
    Sucursal								Sucursal
    Comercial								Comercial    
    */
    
    public ClienteId ejecutar(AltaDeClienteComando comando) {
        if (comando == null) {
            throw new IllegalArgumentException("el comando no puede ser nulo");
        }

        // Del DTO a los Value Objects: aquí se validan los datos recibidos.
        Nombre nombre = Nombre.of(comando.nombre());
        Direccion direccion = Direccion.of(
        		comando.calle(), 
        		comando.ciudad(), 
        		comando.codigoPostal(), 
        		comando.pais()
        	);
        CorreoElectronico correo = CorreoElectronico.of(comando.correo());
        Telefono telefono = Telefono.of(comando.telefono());

        //Regla que el cliente no puede comprobar por sí solo: necesita consultar a los demás.
        if (clientes.existePorCorreo(correo)) {
            throw new CorreoYaRegistradoException(correo);
        }

        // La sucursal física más cercana dentro del radio; si no hay ninguna, la online.
        Sucursal sucursal = sucursales.masCercanaA(direccion, Sucursal.RADIO_DE_COBERTURA)
                .orElseGet(sucursales::online);
        Comercial comercial = comerciales.disponibleEn(sucursal.id())
                .orElseThrow(() -> new IllegalStateException(
                        "la sucursal " + sucursal.nombre() + " no tiene comerciales disponibles"));

        Cliente cliente = Cliente.registrar(LocalDate.now(reloj), nombre, direccion, correo, telefono,
                sucursal.id(), comercial.id());
        clientes.guardar(cliente);
        return cliente.id();
    }
}

