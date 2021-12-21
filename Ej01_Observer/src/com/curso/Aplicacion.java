package com.curso;

import com.curso.modelo.entidad.Pedido;
import com.curso.observadores.GestorEnvios;
import com.curso.observadores.GestorFacturas;
import com.curso.observadores.GestorMensajes;
import com.curso.observadores.GestorPedidos;

public class Aplicacion {

	public static void main(String[] args) throws InterruptedException {
		
		GestorPedidos  gp = new GestorPedidos();
		GestorFacturas gf = new GestorFacturas();
		GestorEnvios   ge = new GestorEnvios();
		GestorMensajes gm = new GestorMensajes();
		
		System.out.println("=====================================");		
		for(int a=1; a<10; a++) {	
			Pedido p = new Pedido("PED-"+a,"Fecha"+a, "Cliente"+a,a*25d);
			gp.crearOrdenDeCompra(p);
			Thread.sleep(1000);
		}
				
	}
	
}
