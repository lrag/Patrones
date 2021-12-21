package curso.patrones.iterador;

import java.util.ArrayList;
import java.util.List;

public class MenuCenas {
	List itemsMenu=new ArrayList();
	
	
	public void añadir(ItemMenu item){
		itemsMenu.add(item);
	}


	public Iterador crearIterador(){
		return new MenuCenasIterador(itemsMenu);
	}
	

}
