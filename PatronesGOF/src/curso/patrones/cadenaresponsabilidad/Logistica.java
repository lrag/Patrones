package curso.patrones.cadenaresponsabilidad;

public class Logistica extends TratamientoFactura{
	public Logistica(TratamientoFactura siguiente) {
		super(siguiente);
	}



	@Override
	public void tratar(Factura factura) {
		preparar(factura);
		if(siguiente!=null)
			siguiente.tratar(factura);
		
	}
	public void preparar(Factura factura){
		System.out.println("preparando "+factura);
	}
}
