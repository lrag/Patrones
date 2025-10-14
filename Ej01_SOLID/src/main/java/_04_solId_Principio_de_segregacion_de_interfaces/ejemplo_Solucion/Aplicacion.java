package _04_solId_Principio_de_segregacion_de_interfaces.ejemplo_Solucion;

import java.util.ArrayList;
import java.util.List;

public class Aplicacion {

	public static void main(String[] args) {
		
		Andador ga = new Gallina();
		Volador go = new Gorrion();
		Nadador lucas = new Pato();
		
		ga.volar(); //Para qué?
		//go.nadar(); //??
		//ga.andar();
		go.volar();
		lucas.nadar();
		
		List<Volador> voladores = new ArrayList<>();
		voladores.add(new Gorrion());		
		voladores.add(new Pato());
		
		for(Volador v : voladores) {
			v.volar();
		}
		
	}
	
}
