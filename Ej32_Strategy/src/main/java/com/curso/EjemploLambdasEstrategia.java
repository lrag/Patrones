package com.curso;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class EjemploLambdasEstrategia {

	public static void main(String[] args) {
		
		ArrayListChungo<String> palabras = new ArrayListChungo<>();
		palabras.add("siete");
		palabras.add("caballos");
		palabras.add("vienen");
		palabras.add("de");
		palabras.add("Bonanza");
		
		System.out.println("=========================================");
		for(int a=0; a<palabras.size(); a++) {
			System.out.println(":::::"+palabras.get(a));
		}	
		for(int a=0; a<palabras.size(); a++) {
			System.out.println(">>>>>"+palabras.get(a));
		}
	 	
		System.out.println("=========================================");

		palabras.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println("<<<<<"+s);
			}
		});
		
		
		/*
		
		(String s) {
			syso...
			...
			...
		}
		
		
		*/
		
		palabras.forEach( s -> System.out.println("<<<<<"+s) );
		palabras.forEach( s -> System.out.println(":::::"+s) );
		palabras.forEach( s -> System.out.println(">>>>>"+s) );	
		
	}
	
}

class ArrayListChungo<T> {
	
	private Object[] elementos = new Object[20];
	private int contador;
	
	public void add(T elem) {
		elementos[contador] = elem;
		contador++;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int pos) {
		return (T) elementos[pos];
	}
	
	public int size() {
		return contador;
	}	

	//Esto es un patrón estrategia
	//Recibimos la estrategia por parámetro
	public void forEach(Consumer<T> action) {
		for(Object obj: elementos) {
			if(obj == null) {
				break;
			}
			action.accept((T) obj);
		}		
	}
		
}
