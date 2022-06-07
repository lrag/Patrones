package _03_soLid_Principio_de_sustitucion_de_Liskov.ejemplo2;

public class EEPROM extends Memoria {

	@Override
	public byte leer(long direccion) {
		System.out.println("Leyendo en EEPROM");
		return 0;
	}

	@Override
	public void escribir(long direccion, byte valor) {
		System.out.println("Escribiendo en EEPROM, no sin cierta dificultad y esfuerzo");
	}

}
