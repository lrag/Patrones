package curso.patrones.estado;

public class NoHayMonedaEstado implements Estado {
	MaquinaBebidas maquina;

	public NoHayMonedaEstado(MaquinaBebidas maquina) {
		this.maquina = maquina;
	}

	public void devolverMoneda() {
		System.out.println("no se puede devolver nada pq no hay");

	}

	public void dispensar() {
		System.out.println("no se puede dispensar nada pq no hay");

	}

	public void insertarMoneda() {
		System.out.println("insertando moneda");
		maquina.setEstado(maquina.getHayMonedaEstado());

	}

	public void pulsarBoton() {
		System.out.println("no se puede pulsar el boton si no hay monedas");

	}

}
