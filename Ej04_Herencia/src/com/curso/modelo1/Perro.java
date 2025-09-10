package com.curso.modelo1;

public class Perro extends Animal {

	protected int numeroPulgas;

	public Perro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Perro(String nombre, int numeroPulgas) {
		super(nombre);
		System.out.println("Constructor Perro");
		if(numeroPulgas<0) {
			throw new RuntimeException("Número de pulgas no puede ser negativo");
		}		
		this.numeroPulgas = numeroPulgas;		
	}
	
	public int getNumeroPulgas() {
		return numeroPulgas;
	}

	public void setNumeroPulgas(int numeroPulgas) {
		if(numeroPulgas<0) {
			throw new RuntimeException("Número de pulgas no puede ser negativo");
		}
		this.numeroPulgas = numeroPulgas;
	}

	@Override
	public void voz() {
		System.out.println("Hola, soy el perro "+nombre+" y digo GUAU GUAU");
	}

	@Override
	public String toString() {
		
		String str = super.toString();
		
		System.out.println(this.peso);
		
		return str+"[numeroPulgas=" + numeroPulgas + "]";
	}
	
}
