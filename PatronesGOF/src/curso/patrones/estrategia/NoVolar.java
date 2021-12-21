package curso.patrones.estrategia;

public class NoVolar extends ComportamientoVolador {

	@Override
	public void volar() {
		System.out.println("no puedo volar");

	}

}
