package curso.patrones.memento;

public class Memento {
	private String estado;
	public Memento(String estado){
		this.estado = estado;
	}
	public String getSavedState(){
		return estado;
	}
}
