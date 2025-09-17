package _04_solId_Principio_de_segregacion_de_interfaces.ejemplo;

public class Aplicacion {

	public static void main(String[] args) {
		
		Gallina ga = new Gallina();
		Gorrion go = new Gorrion();
		Pato lucas = new Pato();
		
		//El cliente tiene acceso a más métodos de los que necesita
		
		ga.volar(); //Para qué?
		go.nadar(); //??
				
	}
	
}





