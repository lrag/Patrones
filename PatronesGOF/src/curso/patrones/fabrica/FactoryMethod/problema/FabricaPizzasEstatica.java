package curso.patrones.fabrica.FactoryMethod.problema;

public class FabricaPizzasEstatica {
	public static Pizza crearPizza(String tipo) {
		Pizza pizza=null;
		if(tipo.equals("Americana"))
			pizza=new PizzaAmericana();
		else if(tipo.equals("Italiana")){
			pizza=new PizzaItaliana();
		}else if(tipo.equals("Vegetariana")){
			pizza=new PizzaVegetariana();
		}
		return pizza;
	}
}
