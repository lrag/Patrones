package curso.patrones.fachada.problema;

public class DVD extends Aparato {
	public void play(){
		System.out.println("reproduciendo peli..");
	}
	
	public void stop(){
		System.out.println("peli parada");
	}
}
