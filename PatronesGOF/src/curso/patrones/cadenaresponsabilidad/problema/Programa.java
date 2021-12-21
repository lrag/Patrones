package curso.patrones.cadenaresponsabilidad.problema;

public class Programa {
	public static void main(String[] args) {
		Comercial comercial=new Comercial();
		Logistica logistica=new Logistica();
		Facturacion facturacion=new Facturacion();
		
		Factura factura =new Factura("ordenador",1000);
		comercial.procesar(factura);
		logistica.preparar(factura);
		facturacion.facturar(factura);
		
	}
}
