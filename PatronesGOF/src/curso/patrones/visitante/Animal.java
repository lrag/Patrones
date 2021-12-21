package curso.patrones.visitante;

public class Animal implements ItemClinica{
	String raza;
	double importe;
	
	public Animal() {
	
	}
	
	public Animal(String raza, double importe) {
		this.raza = raza;
		this.importe = importe;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public double getPrecio() {
		return importe;
	}

	public void setPrecio(double importe) {
		this.importe = importe;
	}
	
	@Override
	public String toString() {
		return raza+"--->"+importe;
	}

	public void aceptar(VisitanteVeterinaria visitante) {
		visitante.visitarAnimal(this);
		
	}
}
