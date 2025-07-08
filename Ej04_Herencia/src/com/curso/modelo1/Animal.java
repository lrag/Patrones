package com.curso.modelo1;

public abstract class Animal {

	//Los componente privados no se heredan
	//private String nombre;
	//Los componentes con modificador de acceso de paquete solo se heredan en clases que están en el mismo paquete
	//String nombre;
	protected String nombre;

	public Animal() {
		super();
	}

	public Animal(String nombre) {
		super();
		System.out.println("Constructor Animal");
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public final void vivir() {
		System.out.println("Soy el animal "+nombre+" y aqui estoy, pasando el rato.");
	}
	
	public abstract void voz();

	@Override
	public String toString() {
		
		String str = super.toString();
		
		return str+" [nombre=" + nombre + "]";
	}
	
	

}






