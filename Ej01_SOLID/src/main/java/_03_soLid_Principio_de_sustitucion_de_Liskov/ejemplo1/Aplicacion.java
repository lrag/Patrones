package _03_soLid_Principio_de_sustitucion_de_Liskov.ejemplo1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Aplicacion {

	public static void main(String[] args) {
		
		System.out.println("===================================");
		Collection<String> c1 = Aplicacion.listar1();
		c1.forEach(s -> System.out.println(s));
		
		System.out.println("===================================");
		List<String> l1 = Aplicacion.listar1();
		l1.add("EOF");
		c1.forEach(s -> System.out.println(s));
		
		System.out.println("===================================");
		List<String> l2 = Aplicacion.listar2();
		l2.add("EOF");
		l1.forEach(s -> System.out.println(s));
		
		System.out.println();
		
		System.out.println("===================================");
		Collection<String> c2 = Aplicacion.listar3();
		c2.forEach(s -> System.out.println(s));

		System.out.println("===================================");
		Set<String> s1 = Aplicacion.listar3();
		s1.add("EOF");
		s1.forEach(s -> System.out.println(s));

		System.out.println("===================================");
		Set<String> s2 = Aplicacion.listar4();
		s2.add("EOF");
		s2.forEach(s -> System.out.println(s));
		
	}
	
	static List<String> listar1(){
		ArrayList<String> lista = new ArrayList<>();
		lista.add("HELLO");
		lista.add("NAME");
		lista.add("DOCTOR");
		lista.add("CONTINUE");
		lista.add("YESTERDAY");
		lista.add("TOMORROW");
		return lista;
	}

	static List<String> listar2(){
		LinkedList<String> lista = new LinkedList<>();
		lista.add("LA");
		lista.add("PARTE");
		lista.add("CONTRATANTE");
		lista.add("DE");
		lista.add("LA");
		lista.add("PRIMERA");
		lista.add("PARTE");
		return lista;
	}

	static Set<String> listar3(){
		HashSet<String> set = new HashSet<>();
		set.add("EL");
		set.add("SOL");
		set.add("SALIO");
		set.add("ANOCHE");
		set.add("Y");
		set.add("ME");
		set.add("CANTO");
		return set;
	}
	
	static Set<String> listar4(){
		TreeSet<String> set = new TreeSet<>();
		set.add("LA");
		set.add("TUMBA");
		set.add("SIN");
		set.add("NOMBRE");
		set.add("JUNTO");
		set.add("A");
		set.add("LA");
		set.add("DE");
		set.add("STANTON");
		return set;
	}	
	
}
