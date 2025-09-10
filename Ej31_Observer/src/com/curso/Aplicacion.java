package com.curso;

import com.curso.modelo.entidad.Pedido;
import com.curso.observadores.ServicioEnvios;
import com.curso.observadores.ServicioFacturas;
import com.curso.observadores.ServicioMensajes;
import com.curso.observadores.ServicioPedidos;

public class Aplicacion {

	public static void main(String[] args) throws InterruptedException {
		
		long inicio = System.currentTimeMillis();
		
		ServicioPedidos  gp = new ServicioPedidos();
		
		ServicioFacturas gf = new ServicioFacturas();
		ServicioEnvios   ge = new ServicioEnvios();
		ServicioMensajes gm = new ServicioMensajes();
		
		
		for(int a=0; a<10; a++) {	
			Pedido p = new Pedido("PED-"+a,"Fecha"+a, "Cliente"+a,a*25d);
			gp.crearOrdenDeCompra(p);
		}
		
		long tiempo = System.currentTimeMillis()-inicio;
		Thread.sleep(1500);
		System.out.println("////////////////");
		System.out.println("// FIN: "+tiempo+" //");
		System.out.println("////////////////");	
				
	}
	
}
