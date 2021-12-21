package curso.patrones.decorador.problema;

public class Cafe extends Bebida{

	@Override
	public float calcularPrecio() {
		return super.calcularPrecio()+1;
	}
	
	@Override
	public String getDescripcion() {
		return "cafe";
	}
}
