package curso.patrones.fachada;

public class Aparato {

	private boolean encendido;

	public Aparato() {
		super();
	}

	public boolean isEncendido() {
		return encendido;
	}

	public void setEncendido(boolean encendido) {
		this.encendido = encendido;
		System.out.println(getClass().getName()+":"+(encendido?"ON":"OFF"));
	}

}