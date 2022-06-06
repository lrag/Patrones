package _03_soLid_Principio_de_sustitucion_de_Liskov.ejemplo3;

public class CD_RW extends DiscoGrabable {

	private boolean grabado;
	
	@Override
	public byte leer(long direccion) {
		System.out.println("Leyendo del CD-RW");
		return 0;
	}

	@Override
	public void escribir(long direccion) {
		System.out.println("Grabando en el CD-RW");
	}
	
}
