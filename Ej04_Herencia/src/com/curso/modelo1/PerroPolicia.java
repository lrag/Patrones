package com.curso.modelo1;

public final class PerroPolicia extends Perro {

	private int numeroCasosResueltos;

	public PerroPolicia() {
		super();
	}
	
	public PerroPolicia(String nombre, int numeroPulgas, int numeroCasosResueltos) {
		//CASCADA DE CONSTRUCTORES
		super(nombre, numeroPulgas);
		System.out.println("Constructor PerroPolicía");
		this.numeroCasosResueltos = numeroCasosResueltos;		
	}

	@Override
	public String toString() {
		
		String str = super.toString();
		
		return str+ "[numeroCasosResueltos=" + numeroCasosResueltos + "]";
	}
	
	
	
}



