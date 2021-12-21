package curso.patrones.fabrica.FactoryMethod;

public class Pizza {

	public void preparar() {
		System.out.println("preparando "+getClass().getName());
		
	}

	public void cocinar() {
		System.out.println("cocinando "+getClass().getName());
		
	}

	public void cortar() {
		System.out.println("cortando "+getClass().getName());
		
	}

	public void embalar() {
		System.out.println("embalando "+getClass().getName());
		
	}

}
