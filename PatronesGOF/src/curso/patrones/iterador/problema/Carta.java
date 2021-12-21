package curso.patrones.iterador.problema;

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
		ItemMenu[] itemsMenu1 = desayunos.getItemsMenu();
		for (int i = 0; i < itemsMenu1.length; i++) {
			System.out.println(itemsMenu1[i]);
		}
		System.out.println("CENAS");
		List itemsMenu2=cenas.getItemsMenu();
		for(int j=0;j<itemsMenu2.size();j++){
			System.out.println(itemsMenu2.get(j));
		}
	}
}
