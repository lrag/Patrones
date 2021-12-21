package curso.patrones.estado;

public class SinBebidaEstado implements Estado {
	MaquinaBebidas maquina;

	public SinBebidaEstado(MaquinaBebidas maquina) {
		this.maquina = maquina;
	}
	
	public void devolverMoneda() {
		System.out.println("no hay moneda que devolver");

	}

	public void dispensar() {
		System.out.println("no hay bebida que dispensar");

	}

	public void insertarMoneda() {
		System.out.println("no se puede insertar moneda");

	}

	public void pulsarBoton() {
		System.out.println("no se puede pulsar boton");

	}

}
