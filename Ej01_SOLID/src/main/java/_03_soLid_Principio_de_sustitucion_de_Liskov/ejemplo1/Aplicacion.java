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
		Collection<String> c1 = Aplicacion.listar1(); //List
		c1.add("EOF");
		c1.forEach(s -> System.out.println(s));
		//c1.get(5); Esto solo lo tienen las listas
		
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
		c2.add("EOF");
		c2.forEach(s -> System.out.println(s));

		System.out.println("===================================");
		Set<String> s1 = Aplicacion.listar3();
		s1.add("EOF");
		s1.forEach(s -> System.out.println(s));

		System.out.println("===================================");
		Set<String> s2 = Aplicacion.listar4();
		s2.add("EOF");
		s2.forEach(s -> System.out.println(s));
		
		System.out.println();
		
		
		//Aqui no estamos violando el principio de sustitucion
		//Entre collection y ArrayList, TreeSet, etc existen otras interfaces
		//que añaden métodos y distintos comportamientos
		System.out.println("===================================");
		Collection<String> c3 = Aplicacion.listar1();		
		Collection<String> c4 = Aplicacion.listar3();	
		c3.add("Trololó");
		c3.add("Trololó");
		c3.forEach(s -> System.out.println(s));
		System.out.println("-----------------------------------");
		c4.add("Trololó");
		c4.add("Trololó");
		c4.forEach(s -> System.out.println(s));
		
		
		
		
		/*
		
		
		Collection c1 = new ArrayList();
		Collection c2 = new LinkedList();
		Collection c3 = new TreeSet();
		
		
		c1.add("");
		c2.add("");
		c3.add("");
		
		c3.get(10);
		
		*/
		
		
		
		
		
		
		
		
		
		
	}
	
	static List<String> listar1(){
		List<String> lista = new ArrayList<>();
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
