package curso.patrones.fabrica.FactoryMethod;

public abstract class Pizzeria {
	public final Pizza pedir(String tipo){

		//Es mejor intentar usar la fabrica estatica para no duplicar
		//la creacion de objetos
		//FabricaPizzas fabricaPizzas=new FabricaPizzas();
		Pizza pizza = crearPizza(tipo);
		pizza.preparar();
		pizza.cocinar();
		pizza.cortar();
		pizza.embalar();
		return pizza;
	}

	public abstract Pizza crearPizza(String tipo) ;


}
