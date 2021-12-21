package curso.patrones.decorador;

public class ChocolateDecorator extends BebidaDecorador{

	public ChocolateDecorator(Bebida bebida) {
		super(bebida);
	}

	@Override
	public String getDescripcion() {
		return bebida.getDescripcion()+", chocolate";
	}

	@Override
	public float calcularPrecio() {
		return 0.25f+bebida.calcularPrecio();
	}

}
