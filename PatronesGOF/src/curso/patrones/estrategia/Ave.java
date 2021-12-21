package curso.patrones.estrategia;

public abstract  class Ave {

	private ComportamientoCantador comportamientoCantador=new NoCantar();
	private ComportamientoNadador comportamientoNadador=new NoNadar();
	private ComportamientoVolador comportamientoVolador=new NoVolar();
	private ComportamientoReproductor comportamientoReproductor=new NoPonerHuevos();
	
	public abstract void mostrar();
	
	public void volar(){
		comportamientoVolador.volar();
	}
	public void nadar(){
		comportamientoNadador.nadar();
	}
	public void cantar(){
		comportamientoCantador.cantar();
	}
	
	public void reproducirse(){
		comportamientoReproductor.reproducirse();
	}

	public ComportamientoCantador getComportamientoCantador() {
		return comportamientoCantador;
	}

	public void setComportamientoCantador(
			ComportamientoCantador comportamientoCantador) {
		this.comportamientoCantador = comportamientoCantador;
	}

	public ComportamientoNadador getComportamientoNadador() {
		return comportamientoNadador;
	}

	public void setComportamientoNadador(ComportamientoNadador comportamientoNadador) {
		this.comportamientoNadador = comportamientoNadador;
	}
	
	public ComportamientoVolador getComportamientoVolador() {
		return comportamientoVolador;
	}

	public void setComportamientoVolador(ComportamientoVolador comportamientoVolador) {
		this.comportamientoVolador = comportamientoVolador;
	}

	public ComportamientoReproductor getComportamientoReproductor() {
		return comportamientoReproductor;
	}

	public void setComportamientoReproductor(
			ComportamientoReproductor comportamientoReproductor) {
		this.comportamientoReproductor = comportamientoReproductor;
	}
	

	
}
