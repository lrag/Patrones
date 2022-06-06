package _03_soLid_Principio_de_sustitucion_de_Liskov.ejemplo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Aplicacion {

	public static void main(String[] args) {
		
		System.out.println("===================================");
		
		List<Memoria> memorias = Arrays.asList(
				new RAM(),
				new RAM(),
				new ROM()
			);

		//Un forEach :)
		for(Memoria m : memorias) {
			m.leer(1);
			//m.escribir(1l, (byte)0);
		}
		
		for(Memoria m : memorias) {
			m.leer(1);
			if(m instanceof RAM) {
				m.escribir(1l, (byte)0);
			}
		}
		
	}
	
}
