package curso.patrones.iterador;

import java.util.List;

public class MenuCenasIterador implements Iterador {
	private int pos;
	private List itemsMenu;

	public MenuCenasIterador(List itemsMenu) {
		this.itemsMenu=itemsMenu;
	}

	public Object siguiente() {
		return itemsMenu.get(pos++);
	}

	public boolean tieneSiguiente() {
		return pos<itemsMenu.size();
	}

}
