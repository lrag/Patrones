package curso.patrones.cadenaresponsabilidad;

public class Comercial extends TratamientoFactura {
	public void procesar(Factura factura){
		System.out.println("procesando "+factura);
	}
	
	public Comercial(TratamientoFactura siguiente) {
		super(siguiente);
	}



	@Override
	public void tratar(Factura factura) {
		procesar(factura);
		if(siguiente!=null)
			siguiente.tratar(factura);
		
	}
}
