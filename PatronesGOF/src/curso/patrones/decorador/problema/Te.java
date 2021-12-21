package curso.patrones.decorador.problema;

public class Te extends Bebida {

	@Override
	public float calcularPrecio() {
		return super.calcularPrecio()+1.20f;
	}

	@Override
	public String getDescripcion() {
		return "te";
	}
}
