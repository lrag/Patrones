package curso.patrones.comando;

public class EncerderLuzCmd implements Comando {
	Luz luz;

	public EncerderLuzCmd(Luz luz) {
		this.luz = luz;
	}

	public void ejecutar() {
		luz.encender();
	}

	public void deshacer() {
		luz.apagar();
		
	}

}
