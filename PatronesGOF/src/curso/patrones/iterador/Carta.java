package curso.patrones.iterador;

import java.util.List;

public class Carta {
	MenuDesayunos desayunos;
	MenuCenas cenas;
	
	
	public Carta(MenuDesayunos desayunos, MenuCenas cenas) {
		this.desayunos = desayunos;
		this.cenas = cenas;
	}


	public void imprimir(){
		System.out.println("carta del restaurante\n----------------------------");
		System.out.println("DESAYUNOS");
		Iterador iteradorDesayunos=desayunos.crearIterador();
		imprimirElementos(iteradorDesayunos);
		System.out.println("CENAS");
		Iterador iteradorCenas=cenas.crearIterador();
		imprimirElementos(iteradorCenas);
	}
	
	public void imprimirElementos(Iterador iterador){
		while(iterador.tieneSiguiente()){
			System.out.println(iterador.siguiente());
		}
	}
}
