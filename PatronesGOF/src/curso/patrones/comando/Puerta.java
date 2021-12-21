package curso.patrones.comando;

public class Puerta {
	String sitio;

	public Puerta(String sitio) {
		this.sitio = sitio;
	}
	
	public void abrir(){
		System.out.println(sitio+" puerta abierta.");
	}
	
	public void cerrar(){
		System.out.println(sitio+" puerta cerrada.");
	}
	
}
