package _04_solId_Principio_de_segregacion_de_interfaces.ejemplo2;

public class Aplicacion {

	public static void main(String[] args) {
		
		Gallina ga = new Gallina();
		Gorrion go = new Gorrion();
		Pato lucas = new Pato();
		
		//ga.volar(); //Para qué?
		//go.nadar(); //??
		ga.andar();
		go.volar();
		lucas.nadar();
		
	}
	
}
