package _02_sOlid_Principio_de_abierto_cerrado_ejemplo2;

public class Aplicacion {

	public static void main(String[] args) throws Exception {
		
		System.out.println("===============================================");
		Producto p1 = new Producto("Teclado AT", TipoProducto.HARDWARE);
		Producto p2 = new Producto("Witcher 3", TipoProducto.SOFTWARE);
		
		ServicioProductos_MAL spm = new ServicioProductos_MAL();
		spm.altaProducto(p1);
		spm.altaProducto(p2);

		System.out.println("===============================================");

		ServicioProductos sph = new ServicioProductosHardware();
		ServicioProductos sps = new ServicioProductosSoftware();
		sph.altaProducto(p1);
		sps.altaProducto(p2);
		
	}
	
}
