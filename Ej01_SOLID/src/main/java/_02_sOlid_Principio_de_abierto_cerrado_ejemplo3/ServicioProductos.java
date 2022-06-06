package _02_sOlid_Principio_de_abierto_cerrado_ejemplo3;

public class ServicioProductos {

	private AltaProductoStrategy altaProductoStrategy;
	
	public ServicioProductos(AltaProductoStrategy altaProductoStrategy) {
		super();
		this.altaProductoStrategy = altaProductoStrategy;
	}

	public void altaProducto(Producto producto) throws Exception {
		
		//1-Insertar el producto y poco más
		
		//2-Ahora hay que validar algo del producto: bien
		if(producto.getNombre() == null) {
			throw new Exception("Producto invalido");
		}
		
		altaProductoStrategy.ejecutar(producto);
		
		System.out.println("Alta del producto: "+producto);
	}
	
}
