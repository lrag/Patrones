package curso.patrones.cadenaresponsabilidad;

import curso.patrones.cadenaresponsabilidad.Factura;

public class Facturacion extends TratamientoFactura{
	public Facturacion(TratamientoFactura siguiente) {
		super(siguiente);
	}

	public void facturar(Factura factura){
		System.out.println("facturando "+factura);
	}

	@Override
	public void tratar(Factura factura) {
		facturar(factura);
		if(siguiente!=null)
			siguiente.tratar(factura);
		
	}
}
