package curso.patrones.decorador.app;

import curso.patrones.decorador.Bebida;
import curso.patrones.decorador.BebidaDecorador;

public class AguaAzaharDecorator extends BebidaDecorador {

	public AguaAzaharDecorator(Bebida bebida) {
		super(bebida);
	}

	@Override
	public String getDescripcion() {
		return bebida.getDescripcion()+", con agua de azahar";
	}

	@Override
	public float calcularPrecio() {
		return 0.30f+bebida.calcularPrecio();
	}

}
