package curso.patrones.observador;

import java.util.ArrayList;

public abstract class Tema {
	protected ArrayList observadores=new ArrayList();
	public void registrarObservador(Observador o){
		observadores.add(o);
	}
	public void borrarObservador(Observador o){
		observadores.remove(o);
	}
	
	public abstract void notificarObservadores();
}
