package com.curso.modelo.negocio;

public class GestorBancos {

	private static GestorBancos instancia;
	
	public synchronized static GestorBancos getInstancia() {
		if(instancia == null) {
			instancia = new GestorBancos();
		}
		return instancia;
	}	
	
	private GestorBancos() {
	}
	
	public void comprobarTC(Integer numeroTC) throws Exception{
	
		System.out.print("comprobando TC...");
		
		if(numeroTC<5000) {
			System.out.println("MAL");
			throw new Exception("Datos bancarios incorrectos");
		}
		
		System.out.println("OK");
	}	
	
}






