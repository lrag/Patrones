package com.curso;

import com.curso.modelo.entidad.Pedido;
import com.curso.observadores_asincrono.GestorEnvios;
import com.curso.observadores_asincrono.GestorFacturas;
import com.curso.observadores_asincrono.GestorMensajes;
import com.curso.observadores_asincrono.GestorPedidos;

public class AplicacionAsincrono {

	public static void main(String[] args) throws InterruptedException {
		
		long inicio = System.currentTimeMillis();		
		
		GestorPedidos  gp = new GestorPedidos();
		GestorFacturas gf = new GestorFacturas();
		GestorEnvios   ge = new GestorEnvios();
		GestorMensajes gm = new GestorMensajes();
		
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
