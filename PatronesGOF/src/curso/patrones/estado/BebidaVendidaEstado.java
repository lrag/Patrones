package curso.patrones.estado;

public class BebidaVendidaEstado implements Estado {
	MaquinaBebidas maquina;

	public BebidaVendidaEstado(MaquinaBebidas maquina) {
		this.maquina = maquina;
	}

	public void devolverMoneda() {
		System.out.println("no se puede devolver moneda mientras se sirve la bebida");

	}

	public void dispensar() {
		System.out.println("tome su bebida");
		maquina.setContador(maquina.getContador()-1);
		if(maquina.getContador()>0)
			maquina.setEstado(maquina.getNoHayMonedaEstado());
		else
			maquina.setEstado(maquina.getSinBebidaEstado());
	}

	public void insertarMoneda() {
		System.out.println("no se puede insertar moneda mientras se sirve la bebida");

	}

	public void pulsarBoton() {
		System.out.println("no se puede volver a pulsar mientras se sirve la bebida");

	}

}
