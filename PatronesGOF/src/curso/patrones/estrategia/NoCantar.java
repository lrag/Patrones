package curso.patrones.estrategia;

public class NoCantar extends ComportamientoCantador{

	@Override
	public void cantar() {
		System.out.println(".");
		
	}

}
