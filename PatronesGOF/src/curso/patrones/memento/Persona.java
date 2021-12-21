package curso.patrones.memento;

public class Persona {
	private String nombre;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Memento saveToMemento(){
		System.out.println("Originator: Guardando memento");
		return new Memento(nombre);
	}
	public void restoreFromMemento(Memento memento){
		nombre = memento.getSavedState();
	}
	
}
