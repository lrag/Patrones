package _02_sOlid_Principio_de_abierto_cerrado_ejemplo3;

public class Aplicacion {

	public static void main(String[] args) throws Exception {
		
		System.out.println("===============================================");
		Producto p1 = new Producto("Teclado AT", TipoProducto.HARDWARE);
		Producto p2 = new Producto("Witcher 3", TipoProducto.SOFTWARE);
		Producto p3 = new Producto("Movidas gordísimas", TipoProducto.CONSULTORIA);
		
		ServicioProductos sph = new ServicioProductos(new AltaProductoHardwareStrategy());
		ServicioProductos sps = new ServicioProductos(new AltaProductoSoftwareStrategy());
		ServicioProductos spc = new ServicioProductos(new AltaProductoConsultoriaStrategy());
		
		sph.altaProducto(p1);
		sps.altaProducto(p2);
		spc.altaProducto(p3);
		
	}
	
}
