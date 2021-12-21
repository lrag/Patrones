package curso.patrones.decorador;

public class Cafe extends Bebida{

	@Override
	public float calcularPrecio() {
		return 1;
	}
	
	@Override
	public String getDescripcion() {
		return "cafe";
	}
}
