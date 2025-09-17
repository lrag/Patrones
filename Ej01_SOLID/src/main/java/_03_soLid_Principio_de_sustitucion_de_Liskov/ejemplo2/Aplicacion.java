package _03_soLid_Principio_de_sustitucion_de_Liskov.ejemplo2;

import java.util.Arrays;
import java.util.List;

public class Aplicacion {

	public static void main(String[] args) {
		
		System.out.println("===================================");
		
		List<Memoria> memorias = Arrays.asList(
				new RAM(),
				new EEPROM(),
				new ROM()
			);

		//Un forEach :)
		for(Memoria m : memorias) {
			m.leer(1);
			//m.escribir(1l, (byte)0);
		}
		
		System.out.println("==================================");
		for(Memoria m : memorias) {
			m.leer(1);
			//Como no esta respetando el principio de sustitución de Barbara necesitamos este
			//horrendo if y su instanceof
			if(m instanceof RAM || m instanceof EEPROM) {
				m.escribir(1l, (byte)0);
			}
		}
		
	}
	
}
