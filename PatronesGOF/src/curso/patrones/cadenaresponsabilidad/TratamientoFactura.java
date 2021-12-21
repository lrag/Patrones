package curso.patrones.cadenaresponsabilidad;

public abstract class TratamientoFactura {
	protected TratamientoFactura siguiente;
	
	public TratamientoFactura(TratamientoFactura siguiente) {
		this.siguiente = siguiente;
	}

	public abstract void tratar(Factura factura);
}
