package _04_solId_Principio_de_segregacion_de_interfaces.ejemplo2;

public class Gorrion implements Volador, Andador {

	public void volar() {
		System.out.println("Soy el gorri�n y vuelo");
	}

	public void andar() {
		System.out.println("Soy la gorri�n y ando");
	}
	
	public void voz() {
		System.out.println("Soy la gorri�n y pio pio");
	}
	
}
