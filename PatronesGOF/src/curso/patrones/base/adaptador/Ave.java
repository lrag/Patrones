package curso.patrones.base.adaptador;

public abstract  class Ave {
	public void volar(){
		System.out.println("volando voy...");
	}
	
	public void nadar(){
		System.out.println("estoy en el agua");
	}
	
	public abstract void mostrar();
	
	//funcionalidad añadida más tarde que obliga
	// a retocar todas las clases
	public abstract void cantar();
	
}
