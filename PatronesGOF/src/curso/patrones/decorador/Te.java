package curso.patrones.decorador;

public class Te extends Bebida {

	@Override
	public float calcularPrecio() {
		return 1.20f;
	}

	@Override
	public String getDescripcion() {
		return "te";
	}
}
