package _03_soLid_Principio_de_sustitucion_de_Liskov.ejemplo3;

public class CD_ROM extends Disco {

	@Override
	public byte leer(long direccion) {
		System.out.println("Leyendo del CD-ROM");
		return 0;
	}

	
	
}
