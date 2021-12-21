package curso.patrones.fabrica.FactoryMethod.problema;

public class PizzeriaCaceres {
	public Pizza pedir(String tipo){

		//Es mejor intentar usar la fabrica estatica para no duplicar
		//la creacion de objetos
		//FabricaPizzas fabricaPizzas=new FabricaPizzas();
		Pizza pizza = FabricaPizzasCaceresEstatica.crearPizza(tipo);
		
		pizza.preparar();
		pizza.cocinar();
		pizza.cortar();
		pizza.embalar();
		return pizza;
	}


}
