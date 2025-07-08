package com.curso.modelo2;

import com.curso.modelo1.Animal;

public class Gato extends Animal {

	private int longitudBigotes;

	@Override
	public void voz() {
		System.out.println("Hola, soy el gato "+nombre+" y digo MIAU MIAU!");		
	}
	
	
	
}
