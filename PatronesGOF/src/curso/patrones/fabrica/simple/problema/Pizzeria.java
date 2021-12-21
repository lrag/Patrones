package curso.patrones.fabrica.simple.problema;

public class Pizzeria {
	public Pizza pedir(String tipo){
		//no queremos tener regada por la aplicacion
		//la instanciacion de clases concretas mejor
		//llevar este fragmento a un unico sitio--> fabrica de objetos
		Pizza pizza=null;
		if(tipo.equals("Americana"))
			pizza=new PizzaAmericana();
		else if(tipo.equals("Italiana")){
			pizza=new PizzaItaliana();
		}else if(tipo.equals("Vegetariana")){
			pizza=new PizzaVegetariana();
		}
		
		pizza.preparar();
		pizza.cocinar();
		pizza.cortar();
		pizza.embalar();
		return pizza;
	}
}
