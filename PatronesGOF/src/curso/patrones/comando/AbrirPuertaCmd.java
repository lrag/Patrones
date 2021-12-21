package curso.patrones.comando;

public class AbrirPuertaCmd implements Comando {
	Puerta puerta;

	public AbrirPuertaCmd(Puerta puerta) {
		this.puerta = puerta;
	}

	public void ejecutar() {
		puerta.abrir();
	}

	public void deshacer() {
		puerta.cerrar();
		
	}

}
