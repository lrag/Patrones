package curso.patrones.comando;

public class Luz {
	String sitio;

	public Luz(String sitio) {
		this.sitio = sitio;
	}
	
	public void encender(){
		System.out.println(sitio+" luz encendida.");
	}
	
	public void apagar(){
		System.out.println(sitio+" luz apagada.");
	}
	
}
