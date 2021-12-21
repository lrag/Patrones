package curso.patrones.fabrica.FactoryMethod.problema;

public class FabricaPizzasCaceresEstatica {
	public static Pizza crearPizza(String tipo) {
		Pizza pizza=null;
		if(tipo.equals("Americana"))
			pizza=new PizzaAmericanaCaceres();
		else if(tipo.equals("Italiana")){
			pizza=new PizzaItalianaCaceres();
		}else if(tipo.equals("Vegetariana")){
			pizza=new PizzaVegetarianaCaceres();
		}
		return pizza;
	}
}
