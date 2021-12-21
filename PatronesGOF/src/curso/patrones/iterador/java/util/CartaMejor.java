package curso.patrones.iterador.java.util;

import java.util.Iterator;
import java.util.List;

public class CartaMejor {
	List menus;
	
	
	public CartaMejor(List menus) {
		this.menus = menus;
	}


	public void imprimir(){
		System.out.println("carta del restaurante\n----------------------------");
		Iterator iteratorMenus = menus.iterator();
		while(iteratorMenus.hasNext()){
			Menu menu = (Menu) iteratorMenus.next();
			System.out.println(menu.getClass().getSimpleName().toUpperCase());
			imprimirElementos(menu.crearIterador());
		}
	
	}
	
	public void imprimirElementos(Iterator iterador){
		while(iterador.hasNext()){
			System.out.println(iterador.next());
		}
	}
}
