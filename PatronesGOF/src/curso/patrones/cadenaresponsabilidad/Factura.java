package curso.patrones.cadenaresponsabilidad;

public class Factura {
	String concepto;
	double importe;
	
	public Factura() {
	
	}
	
	public Factura(String concepto, double importe) {
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
}
