package curso.patrones.fabrica.FactoryMethod.problema;

public class FabricaPizzasMadridEstatica {
	public static Pizza crearPizza(String tipo) {
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
