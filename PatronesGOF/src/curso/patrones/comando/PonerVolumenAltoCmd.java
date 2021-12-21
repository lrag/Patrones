package curso.patrones.comando;

public class PonerVolumenAltoCmd implements Comando {
	CadenaHIFI cadenaHIFI;
	int volumenAnterior;
	

	public PonerVolumenAltoCmd(CadenaHIFI cadenaHIFI) {
		this.cadenaHIFI = cadenaHIFI;
		volumenAnterior=cadenaHIFI.getVolumen();
	}

	public void deshacer() {
		cadenaHIFI.setVolumen(volumenAnterior);

	}

	public void ejecutar() {
		volumenAnterior=cadenaHIFI.getVolumen();
		cadenaHIFI.setVolumen(75);

	}

}
