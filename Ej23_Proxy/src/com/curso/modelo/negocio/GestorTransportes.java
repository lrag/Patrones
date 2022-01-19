package com.curso.modelo.negocio;

public class GestorTransportes {

	private static GestorTransportes instancia;
	
	public synchronized static GestorTransportes getInstancia() {
		if(instancia == null) {
			instancia = new GestorTransportes();
		}
		return instancia;
	}
	
	private GestorTransportes() {
	}
	
	public String obtenerCamion(boolean hayCamion) throws Exception{
		
		System.out.print("Reservando un camión...");
		if(!hayCamion) {
			System.out.println("MAL");
			throw new Exception("No hay camion");
		}
		
		System.out.println("OK");
		return "MOOOOC MOOOOOOC!";		
	}
	
}
