package curso.patrones.decorador;

public class LimonDecorator extends BebidaDecorador{

	public LimonDecorator(Bebida bebida) {
		super(bebida);
	}

	@Override
	public String getDescripcion() {
		return bebida.getDescripcion()+", limon";
	}

	@Override
	public float calcularPrecio() {
		return 0.05f+bebida.calcularPrecio();
	}

}
