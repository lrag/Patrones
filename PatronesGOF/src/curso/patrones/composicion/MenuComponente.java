package curso.patrones.composicion;

public abstract class MenuComponente {
	
	//métodos comunes de las hojas y los nodos
	public abstract void imprimir();
	
	//metodos propios del patron
	public void añadir(MenuComponente componente){
		throw new UnsupportedOperationException();
	}
	
	public void borrar(MenuComponente componente){
		throw new UnsupportedOperationException();
	}
	
	public MenuComponente get(int pos){
		throw new UnsupportedOperationException();		
	}

}
