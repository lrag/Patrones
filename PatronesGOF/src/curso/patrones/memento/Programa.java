package curso.patrones.memento;

public class Programa {
	public static void main(String[] args) {
		Cuidador cuidador = new Cuidador();
		Persona p = new Persona();
		p.setNombre("Ruben");
		p.setNombre("Victor");
		cuidador.addMemento(p.saveToMemento());
		p.setNombre("Luis");
		cuidador.addMemento(p.saveToMemento());
		p.setNombre("Alberto");
		Memento m1 = cuidador.getMemento(0);
		Memento m2 = cuidador.getMemento(1);
		p.restoreFromMemento(m2);
		System.out.println(p.getNombre());
		p.restoreFromMemento(m1);
		System.out.println(p.getNombre());
		
	}
}
