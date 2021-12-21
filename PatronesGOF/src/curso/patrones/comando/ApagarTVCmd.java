package curso.patrones.comando;

public class ApagarTVCmd implements Comando {
	TV tv;

	public ApagarTVCmd(TV tv) {
		this.tv = tv;
	}

	public void ejecutar() {
		tv.off();
	}

	public void deshacer() {
		tv.on();
		
	}

}
