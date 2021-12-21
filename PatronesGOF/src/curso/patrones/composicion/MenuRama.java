package curso.patrones.composicion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MenuRama extends MenuComponente {
	String nombre;
	
	public MenuRama(String nombre) {
		this.nombre = nombre;
	}
	
	List items=new ArrayList();
	
	@Override
	public void añadir(MenuComponente componente) {
		items.add(componente);
	}
	
	
	@Override
	public void borrar(MenuComponente componente) {
		items.remove(componente);
	}
	
	@Override
	public MenuComponente get(int pos) {
		return (MenuComponente) items.get(pos);
	}
	
	@Override
	public void imprimir() {
		Iterator iterator = items.iterator();
		System.out.println(nombre.toUpperCase()+"\n--------------------------------");
		while(iterator.hasNext()){
			MenuComponente componente=(MenuComponente) iterator.next();
			
			componente.imprimir();
		}

	}






}
