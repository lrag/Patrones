package curso.patrones.decorador;

public class LecheDecorator extends BebidaDecorador{

	public LecheDecorator(Bebida bebida) {
		super(bebida);
	}

	@Override
	public String getDescripcion() {
		return bebida.getDescripcion()+", leche";
	}

	@Override
	public float calcularPrecio() {
		return 0.10f+bebida.calcularPrecio();
	}

}
