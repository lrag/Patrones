package curso.patrones.iterador;

public class ItemMenu {
	private String nombre;
	private String descripción;
	private double precio;
	private boolean vegetariano;
	
	public ItemMenu() {
	
	}

	public ItemMenu(String nombre, String descripción, double precio,
			boolean vegetariano) {
		this.nombre = nombre;
		this.descripción = descripción;
		this.precio = precio;
		this.vegetariano = vegetariano;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripción() {
		return descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isVegetariano() {
		return vegetariano;
	}

	public void setVegetariano(boolean vegetariano) {
		this.vegetariano = vegetariano;
	}
	
	@Override
	public String toString() {
		return nombre+"-->"+precio+(vegetariano?"(V)":"")+"\n"+descripción+"\n";
	}
	
}
