package curso.patrones.estrategia.app;


import curso.patrones.estrategia.Cloclear;
import curso.patrones.estrategia.Gallina;
import curso.patrones.estrategia.Gallo;
import curso.patrones.estrategia.NadarEnRio;
import curso.patrones.estrategia.NoPonerHuevos;
import curso.patrones.estrategia.NoVolar;
import curso.patrones.estrategia.PonerHuevos;
import curso.patrones.estrategia.VolarConAlas;

public class Programa {
	public static void main(String[] args) {
		Gallina gallina=new Gallina();
		gallina.setComportamientoCantador(new Cloclear());
		gallina.setComportamientoNadador(new NadarEnRio());
		gallina.setComportamientoVolador(new NoVolar());
		gallina.setComportamientoReproductor(new PonerHuevos());
		
		gallina.cantar();
		gallina.nadar();
		gallina.volar();
		
		//ahora ya no es un pollito y da pequeños vuelos
		System.out.println("3 meses más tarde");
		gallina.setComportamientoVolador(new VolarConAlas());
		gallina.cantar();
		gallina.nadar();
		gallina.volar();
		gallina.reproducirse();
		
		Gallo gallo=new Gallo(); 
		gallo.setComportamientoNadador(new NadarEnRio());
		gallo.setComportamientoReproductor(new NoPonerHuevos());
		
		gallo.reproducirse();
		gallo.nadar();
		gallo.volar();
	}
}
