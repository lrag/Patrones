package curso.patrones.fabrica.FactoryMethod.app;

import curso.patrones.fabrica.FactoryMethod.PizzeriaCaceres;
import curso.patrones.fabrica.FactoryMethod.PizzeriaMadrid;

public class Programa {
		public static void main(String[] args) {
			PizzeriaCaceres pizzeriaCaceres=new PizzeriaCaceres();
			PizzeriaMadrid pizzeriaMadrid = new PizzeriaMadrid();
			
			pizzeriaCaceres.pedir("Americana");
			
			System.out.println("-------------------------------");
			pizzeriaMadrid.pedir("Italiana");
		}
}
