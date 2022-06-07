package _02_sOlid_Principio_de_abierto_cerrado_ejemplo3;

public class ServicioProductos {

	private AltaProductoStrategy altaProductoStrategy;
	
	//Tambien podríamos recibir la estrategia en una propiedad
	public ServicioProductos(AltaProductoStrategy altaProductoStrategy) {
		super();
		this.altaProductoStrategy = altaProductoStrategy;
	}

	public void altaProducto(Producto producto) throws Exception {
		
		//1-Validar el producto y otra serie de tareas comunes para todos los tipos de productos
		if(producto.getNombre() == null) {
			throw new Exception("Producto invalido");
		}
		
		altaProductoStrategy.ejecutar(producto);
		
		System.out.println("Alta del producto: "+producto);
	}
	
}
