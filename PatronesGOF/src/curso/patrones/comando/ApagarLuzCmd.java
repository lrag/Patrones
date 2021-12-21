package curso.patrones.comando;

public class ApagarLuzCmd implements Comando {
	Luz luz;

	public ApagarLuzCmd(Luz luz) {
		this.luz = luz;
	}

	public void ejecutar() {
		luz.apagar();
	}

	public void deshacer() {
		luz.encender();
		
	}

}
