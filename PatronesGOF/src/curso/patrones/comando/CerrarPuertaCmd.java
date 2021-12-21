package curso.patrones.comando;

public class CerrarPuertaCmd implements Comando {
	Puerta puerta;

	public CerrarPuertaCmd(Puerta puerta) {
		this.puerta = puerta;
	}

	public void ejecutar() {
		puerta.cerrar();
	}

	public void deshacer() {
		puerta.abrir();
		
	}

}
