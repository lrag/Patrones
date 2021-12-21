package curso.patrones.iterador.java.util;

import java.util.Iterator;
import java.util.List;

public class Carta {
	Menu desayunos;
	Menu cenas;
	
	
	public Carta(Menu desayunos, Menu cenas) {
		this.desayunos = desayunos;
		this.cenas = cenas;
	}


	public void imprimir(){
		System.out.println("carta del restaurante\n----------------------------");
		System.out.println("DESAYUNOS");
		Iterator iteradorDesayunos=desayunos.crearIterador();
		imprimirElementos(iteradorDesayunos);
		System.out.println("CENAS");
		Iterator iteradorCenas=cenas.crearIterador();
		imprimirElementos(iteradorCenas);
	}
	
	public void imprimirElementos(Iterator iterador){
		while(iterador.hasNext()){
			System.out.println(iterador.next());
		}
	}
}
