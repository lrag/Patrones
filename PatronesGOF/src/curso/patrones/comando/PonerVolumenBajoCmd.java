package curso.patrones.comando;

public class PonerVolumenBajoCmd implements Comando {
	CadenaHIFI cadenaHIFI;
	int volumenAnterior;
	

	public PonerVolumenBajoCmd(CadenaHIFI cadenaHIFI) {
		this.cadenaHIFI = cadenaHIFI;
		volumenAnterior=cadenaHIFI.getVolumen();
	}

	public void deshacer() {
		cadenaHIFI.setVolumen(volumenAnterior);

	}

	public void ejecutar() {
		volumenAnterior=cadenaHIFI.getVolumen();
		cadenaHIFI.setVolumen(25);

	}

}
