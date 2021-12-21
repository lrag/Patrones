package curso.patrones.decorador;

public abstract class BebidaDecorador extends Bebida{
	protected Bebida bebida;
	
	
	public BebidaDecorador(Bebida bebida) {
		this.bebida = bebida;
	}


	public abstract String getDescripcion();

}
