package curso.patrones.visitante;

public class Articulo implements ItemClinica{
	String concepto;
	double importe;
	
	public Articulo() {
	
	}
	
	public Articulo(String concepto, double importe) {
		this.concepto = concepto;
		this.importe = importe;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	@Override
	public String toString() {
		return concepto+"--->"+importe;
	}

	public void aceptar(VisitanteVeterinaria visitante) {
		visitante.visitarArticulo(this);
		
	}
}
