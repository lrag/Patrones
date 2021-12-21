package curso.patrones.comando;

public class MandoSimple {
	Comando on;
	Comando off;

	public MandoSimple(Comando on, Comando off) {
		this.on = on;
		this.off = off;
	}
	
	public void pulsarOn(){
		on.ejecutar();
	}
	
	public void pulsarOff(){
		off.ejecutar();
	}
	
	
}
