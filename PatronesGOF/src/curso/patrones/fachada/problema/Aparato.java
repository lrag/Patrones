package curso.patrones.fachada.problema;

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