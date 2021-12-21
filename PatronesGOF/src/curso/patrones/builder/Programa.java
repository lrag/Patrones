package curso.patrones.builder;

import java.util.Date;

public class Programa {
	public static void main(String[] args) {
		
		Persona pepe=new Persona("pepe",21,2);
		PersonaBuilder builder=new PersonaFechaEdadBuilder(pepe);
		pepe=builder.construir();
		Persona ana=new Persona("anita",new Date(1000000000L),1.78f);
		PersonaBuilder builder2=new PersonaFechaEdadBuilder(ana);
		ana=builder2.construir();
		System.out.println(pepe);
		System.out.println(ana);
	}
}
