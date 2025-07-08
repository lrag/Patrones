package _02_sOlid_Principio_de_abierto_cerrado_ejemplo2;

public class ServicioProductos_MAL {

	public void altaProducto(Producto producto) throws Exception {
		
		//1-Insertar el producto y poco más
		
		//2-Validar algo del producto: bien
		if(producto.getNombre() == null) {
			throw new Exception("Producto invalido");
		}

		//3-Dos maneras de insertar el producto dependiendo del tipo MAL
		switch(producto.getTipo()) {
			case HARDWARE : 
				System.out.println("Cosas particulares de los productos tipo Hardware");
				break;
			case SOFTWARE : 
				System.out.println("Cosas particulares de los productos tipo Software");
				break;
		}
		
		System.out.println("Alta del producto: "+producto);
	}
	
	
	
}
