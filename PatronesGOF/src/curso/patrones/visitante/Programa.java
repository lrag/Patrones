package curso.patrones.visitante;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Programa {
	public static void main(String[] args) {
		List items=new ArrayList();
		items.add(new Articulo("pecera",10));
		items.add(new Animal("pez rojo",1));
		items.add(new Articulo("acuario",1000));
		items.add(new Animal("boa",1500));
		items.add(new Animal("perro",500));
		
		VisitanteVeterinariaPreciosMayoryMenor visitante=new VisitanteVeterinariaPreciosMayoryMenor();
		VisitanteVeterinariaContador visitante2=new VisitanteVeterinariaContador();
		Iterator iterator = items.iterator();
		while(iterator.hasNext()){
			ItemClinica itemClinica = (ItemClinica) iterator.next();
			itemClinica.aceptar(visitante);
			itemClinica.aceptar(visitante2);
		}
		
		System.out.println("PMAX "+visitante.getPvpMayor());
		System.out.println("PMIN "+visitante.getPvpMenor());
		System.out.println("Animales "+visitante2.getContadorAnimales());
		System.out.println("Articulos "+visitante2.getContadorArticulos());
	}
}
