package curso.patrones.iterador.java.util;

import java.util.Iterator;

public class MenuDesayunosIterador implements Iterator {

	private ItemMenu[] itemsMenu;
	private int pos=0;

	public MenuDesayunosIterador(ItemMenu[] itemsMenu) {
		this.itemsMenu=itemsMenu;
	}
	
	public boolean hasNext() {
		if(pos>=itemsMenu.length||itemsMenu[pos]==null)
			return false;
		else 
			return true;
	}

	public Object next() {
		return itemsMenu[pos++];
	}

	public void remove() {
		throw new UnsupportedOperationException();	
	}

}
