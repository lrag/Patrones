package curso.patrones.decorador.problema;

public class Descafeinado extends Bebida{

	@Override
	public float calcularPrecio() {
		return super.calcularPrecio()+1.10f;
	}

	@Override
	public String getDescripcion() {
		return "descafeinado";
	}
}
