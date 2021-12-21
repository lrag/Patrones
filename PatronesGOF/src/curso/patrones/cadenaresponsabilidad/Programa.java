package curso.patrones.cadenaresponsabilidad;


public class Programa {
	
	public static void main(String[] args) {
		
	//la cadena se suele crear en otra parte del programa
	Facturacion facturacion=new Facturacion(null);
	Logistica logistica=new Logistica(facturacion);
	TratamientoFactura tratamientoFactura=new Comercial(logistica);
	
	
	//solo necesitamos invocar la peticion sobre el primer elemento de la cadena
	Factura factura =new Factura("impresora",1000);
	tratamientoFactura.tratar(factura);
	}
}
