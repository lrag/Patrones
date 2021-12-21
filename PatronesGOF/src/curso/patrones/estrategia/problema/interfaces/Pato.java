package curso.patrones.estrategia.problema.interfaces;

public class Pato extends Ave implements Cantador, Volador, Nadador{

	@Override
	public void mostrar() {
		System.out.println("soy un pato");

	}

	
	public void cantar() {
		System.out.println("cua, cua");
		
	}
	
	public void volar(){
		System.out.println("volando voy...");
	}
	
	public void nadar(){
		System.out.println("estoy en el agua");
	}

}
