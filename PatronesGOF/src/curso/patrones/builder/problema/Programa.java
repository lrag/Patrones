package curso.patrones.builder.problema;

import java.util.Date;

public class Programa {
	public static void main(String[] args) {
		Persona pepe=new Persona("pepe",21,2);
		Persona ana=new Persona("ana",new Date(1000000000000L),1.78f);
		
		System.out.println(pepe);
		System.out.println(ana);
	}
}
