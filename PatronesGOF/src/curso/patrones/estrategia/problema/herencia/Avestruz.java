package curso.patrones.estrategia.problema.herencia;

public class Avestruz extends Ave {

	@Override
	public void mostrar() {
		System.out.println("soy avestruz");

	}
	
	//nueva clase que tiene que anular comportamiento
	//heredado
	@Override
	public void volar() {
	
	}
	
	@Override
	public void cantar() {
		System.out.println("no canto.");
	}

}
