package curso.patrones.iterador.problema;

import java.util.ArrayList;
import java.util.List;

public class MenuCenas {
	List itemsMenu=new ArrayList();
	
	
	public void añadir(ItemMenu item){
		itemsMenu.add(item);
	}


	public List getItemsMenu() {
		return itemsMenu;
	}
	
	

}
