package _02_sOlid_Principio_de_abierto_cerrado_ejemplo2;

public class ServicioProductosHardware implements ServicioProductos{

	@Override
	public void altaProducto(Producto producto) throws Exception {
		//1-Insertar el producto y poco más
		
		//2-Ahora hay que validar algo del producto: bien
		if(producto.getNombre() == null) {
			throw new Exception("Producto invalido");
		}

		System.out.println("Cosas particulares de los productos tipo Hardware");
		
		System.out.println("Alta del producto: "+producto);
	}

}
