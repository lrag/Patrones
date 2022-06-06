package _03_soLid_Principio_de_sustitucion_de_Liskov.ejemplo3;

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
		
		List<Disco> discos = Arrays.asList(
				new CD_ROM(),
				new CD_R(),
				new CD_RW()
			);

		List<DiscoGrabable> discos2 = Arrays.asList(
				//new CD_ROM(),
				new CD_R(),
				new CD_RW()
			);
		
		System.out.println("===================================");		
		for(Disco d: discos) {
			d.leer(0);
			//d.escribir(1,2);
		}

		System.out.println("===================================");		
		for(DiscoGrabable d: discos2) {
			d.leer(0);
			d.escribir(1);
		}

		//:(
		System.out.println("===================================");		
		for(DiscoGrabable d: discos2) {
			d.leer(0);
			d.escribir(2);
		}
		
	}
	
}
