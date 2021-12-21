package curso.patrones.iterador.java.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MenuCenas implements Menu {
	List itemsMenu=new ArrayList();
	
	
	public void añadir(ItemMenu item){
		itemsMenu.add(item);
	}


	public Iterator crearIterador(){
		return itemsMenu.iterator();
	}
	

}
