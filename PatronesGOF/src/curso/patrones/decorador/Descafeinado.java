package curso.patrones.decorador;

public class Descafeinado extends Bebida{


	public float calcularPrecio() {
		return 1.10f;
	}

	@Override
	public String getDescripcion() {
		return "descafeinado";
	}
}
