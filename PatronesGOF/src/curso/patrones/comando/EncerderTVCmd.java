package curso.patrones.comando;

public  class EncerderTVCmd implements Comando {
	TV tv;

	public EncerderTVCmd(TV tv) {
		this.tv = tv;
	}

	public void ejecutar() {
		tv.on();
	}

	public void deshacer() {
		tv.off();
		
	}

}
