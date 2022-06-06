package _02_sOlid_Principio_de_abierto_cerrado_ejemplo3;

public class AltaProductoSoftwareStrategy implements AltaProductoStrategy{

	public void ejecutar(Producto producto) {
		System.out.println("Cosas particulares de los productos tipo Software");		
	}

}
