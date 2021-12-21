package curso.patrones.fabrica.FactoryMethod;

public class PizzeriaMadrid extends Pizzeria{

	@Override
	public Pizza crearPizza(String tipo) {
		Pizza pizza=null;
		if(tipo.equals("Americana"))
			pizza=new PizzaAmericanaMadrid();
		else if(tipo.equals("Italiana")){
			pizza=new PizzaItalianaMadrid();
		}else if(tipo.equals("Vegetariana")){
			pizza=new PizzaVegetarianaMadrid();
		}
		return pizza;
	}



}
