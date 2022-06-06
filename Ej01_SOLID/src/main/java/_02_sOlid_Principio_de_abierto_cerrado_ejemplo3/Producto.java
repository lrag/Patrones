package _02_sOlid_Principio_de_abierto_cerrado_ejemplo3;

public class Producto {

	private String nombre;
	private TipoProducto tipo;

	public Producto() {
		super();
	}

	public Producto(String nombre, TipoProducto tipo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoProducto getTipo() {
		return tipo;
	}

	public void setTipo(TipoProducto tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", tipo=" + tipo + "]";
	}

}
