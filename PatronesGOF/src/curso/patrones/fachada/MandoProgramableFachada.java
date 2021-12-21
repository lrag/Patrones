package curso.patrones.fachada;

public class MandoProgramableFachada {
	private TV tv;
	private EquipoHIFI equipoHIFI;
	private DVD dvd;
	
	
	public MandoProgramableFachada(TV tv, EquipoHIFI equipoHIFI, DVD dvd) {
		this.tv = tv;
		this.equipoHIFI = equipoHIFI;
		this.dvd = dvd;
	}

	public void ponerPeli(){
		dvd.setEncendido(true);
		tv.setEncendido(true);
		equipoHIFI.setEncendido(true);
		dvd.play();
	}
	
	public void paraPeli(){
		dvd.stop();
		dvd.setEncendido(false);
		tv.setEncendido(false);
		equipoHIFI.setEncendido(false);
	}
}
