package curso.patrones.estrategia.problema.herencia;

public class Gallina extends Ave {

	@Override
	public void mostrar() {
		System.out.println("soy una gallina");

	}

	@Override
	public void cantar() {
		System.out.println("clo,clo");
		
	}

}
