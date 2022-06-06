package _03_soLid_Principio_de_sustitucion_de_Liskov.ejemplo3;

public class CD_R extends DiscoGrabable {

	private boolean grabado;
	
	@Override
	public byte leer(long direccion) {
		System.out.println("Leyendo del CD-R");
		return 0;
	}

	@Override
	//No hace lo que dicta la superclase
	public void escribir(long direccion) {
		if(grabado) {
			throw new RuntimeException("El disco ya está grabado!");
		}
		System.out.println("Grabando en el CD-R");
		grabado = true;
	}

	
	
}
