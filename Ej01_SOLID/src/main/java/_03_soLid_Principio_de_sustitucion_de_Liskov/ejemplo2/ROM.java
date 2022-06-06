package _03_soLid_Principio_de_sustitucion_de_Liskov.ejemplo2;

public class ROM extends Memoria {

	@Override
	public byte leer(long direccion) {
		System.out.println("Leyendo en ROM");
		return 0;
	}

	@Override
	public void escribir(long direccion, byte valor) {
		throw new RuntimeException("No se puede escribir en una ROM!");
	}

}
