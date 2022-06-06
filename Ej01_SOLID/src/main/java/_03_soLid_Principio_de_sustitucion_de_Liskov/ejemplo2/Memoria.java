package _03_soLid_Principio_de_sustitucion_de_Liskov.ejemplo2;

public abstract class Memoria {

	private int size;

	public abstract byte leer(long direccion);
	public abstract void escribir(long direccion, byte valor);
	
}
