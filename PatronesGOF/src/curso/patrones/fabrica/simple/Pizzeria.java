package curso.patrones.fabrica.simple;

public class Pizzeria {
	public Pizza pedir(String tipo){

		//Es mejor intentar usar la fabrica estatica para no duplicar
		//la creacion de objetos
		//FabricaPizzas fabricaPizzas=new FabricaPizzas();
		Pizza pizza = FabricaPizzasEstatica.crearPizza(tipo);
		
		//OJO a esto
		//FabricaPizzasEstatica fabricaPizzasEstatica = new FabricaPizzasEstatica();
		//fabricaPizzasEstatica.crearPizza(tipo);
		
		pizza.preparar();
		pizza.cocinar();
		pizza.cortar();
		pizza.embalar();
		return pizza;
	}


}
