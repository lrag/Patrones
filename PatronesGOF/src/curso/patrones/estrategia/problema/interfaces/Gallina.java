package curso.patrones.estrategia.problema.interfaces;

public class Gallina extends Ave implements Cantador, Volador {

	@Override
	public void mostrar() {
		System.out.println("soy una gallina");

	}

	public void cantar() {
		System.out.println("clo,clo");
		
	}
	
	public void volar(){
		System.out.println("volando voy...");
	}
	


}
