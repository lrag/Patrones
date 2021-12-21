package curso.patrones.decorador.problema;

public abstract class Bebida {
	//cada nuevo ingrediente obliga a retocar la clase bebida
	//no controlamos dobles o triples ingredientes
	private boolean conLeche;
	private boolean conLimon;
	private boolean conChocolate;
	
	public String getDescripcion(){
		return "bebida";
	}
	
	//es posible que nuestras subclases se olviden de 
	//calcular el precio de los ingredientes.
	public float calcularPrecio(){
		float precio=1;
		if(isConChocolate())
			precio+=0.20F;
		else if(isConLeche())
			precio+=0.10F;
		else if(isConLimon())
			precio+=0.05F;
		return precio;
	}
	
	public boolean isConLeche() {
		return conLeche;
	}
	public void setConLeche(boolean conLeche) {
		this.conLeche = conLeche;
	}
	public boolean isConLimon() {
		return conLimon;
	}
	public void setConLimon(boolean conLimon) {
		this.conLimon = conLimon;
	}
	public boolean isConChocolate() {
		return conChocolate;
	}
	public void setConChocolate(boolean conChocolate) {
		this.conChocolate = conChocolate;
	}
}
