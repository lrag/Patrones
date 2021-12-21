package curso.patrones.iterador;

public class MenuDesayunosIterador implements Iterador {

	private ItemMenu[] itemsMenu;
	private int pos=0;

	public MenuDesayunosIterador(ItemMenu[] itemsMenu) {
		this.itemsMenu=itemsMenu;
	}

	public Object siguiente() {
		return itemsMenu[pos++];
	}

	public boolean tieneSiguiente() {
		if(pos>=itemsMenu.length||itemsMenu[pos]==null)
			return false;
		else 
			return true;
	}

}
