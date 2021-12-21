package curso.patrones.estado;

public class HayMonedaEstado implements Estado {
	MaquinaBebidas maquina;

	public HayMonedaEstado(MaquinaBebidas maquina) {
		this.maquina = maquina;
	}

	public void devolverMoneda() {
		System.out.println("devolviendo moneda");
		maquina.setEstado(maquina.getNoHayMonedaEstado());
	}

	public void dispensar() {
		System.out.println("pulse el boton primero");

	}

	public void insertarMoneda() {
		System.out.println("no se puede insertar otra moneda");
	}

	public void pulsarBoton() {
		System.out.println("sirviendo bebida");
		maquina.setEstado(maquina.getBebidaVendidaEstado());
		maquina.dispensar();

	}

}
