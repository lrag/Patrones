package curso.patrones.visitante.problema;

import java.util.ArrayList;
import java.util.List;

public class Programa {
	public static void main(String[] args) {
		List items=new ArrayList();
		items.add(new Articulo("pecera",10));
		items.add(new Animal("pez rojo",1));
		items.add(new Articulo("acuario",1000));
		items.add(new Animal("boa",1500));
		items.add(new Animal("perro",500));
		
		double pvpMayor=Integer.MIN_VALUE;
		double pvpMenor=Integer.MAX_VALUE;
		for (int i = 0; i < items.size(); i++) {
			Object o=items.get(i);
			double importeActual=0;
			if(o instanceof Articulo){
				importeActual = ((Articulo)o).getImporte();
				
			}else{
				importeActual = ((Animal)o).getPrecio();
			}
			if(importeActual<pvpMenor)
				pvpMenor=importeActual;
			if(importeActual>pvpMayor)
				pvpMayor=importeActual;
		}
		
		System.out.println("PMAX "+pvpMayor);
		System.out.println("PMIN "+pvpMenor);
	}
}
