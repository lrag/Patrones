package curso.patrones.visitante;

public class VisitanteVeterinariaContador implements VisitanteVeterinaria {
	int contadorAnimales;
	int contadorArticulos;
	
	public void visitarAnimal(Animal a) {
		contadorAnimales++;

	}

	public void visitarArticulo(Articulo a) {
		contadorArticulos++;

	}

	public int getContadorAnimales() {
		return contadorAnimales;
	}

	public void setContadorAnimales(int contadorAnimales) {
		this.contadorAnimales = contadorAnimales;
	}

	public int getContadorArticulos() {
		return contadorArticulos;
	}

	public void setContadorArticulos(int contadorArticulos) {
		this.contadorArticulos = contadorArticulos;
	}

}
