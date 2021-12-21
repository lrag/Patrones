package curso.patrones.memento;

import java.util.ArrayList;

public class Cuidador {
	private ArrayList<Memento> estados = new ArrayList<Memento>();
	
	public void addMemento(Memento m){
		estados.add(m);
	}
	public Memento getMemento(int indice){
		return estados.get(indice);
	}
}
