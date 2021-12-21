package curso.patrones.iterador.java.util;

import java.util.Iterator;

public class MenuDesayunos implements Menu {
	ItemMenu[] itemsMenu=new ItemMenu[3];
	
	
	public void añadir(ItemMenu item){
		int hueco=-1;
		for (int i = 0; i < itemsMenu.length; i++) {
			if(itemsMenu[i]==null){
				hueco=i;
				break;
			}
		}
		if(hueco!=-1)
			itemsMenu[hueco]=item;
		else
			System.out.println("menu lleno");
	}


	/* (non-Javadoc)
	 * @see curso.patrones.iterador.java.util.Menu#crearIterador()
	 */
	public Iterator crearIterador(){
		return new MenuDesayunosIterador(itemsMenu);
	}
	
	

}
