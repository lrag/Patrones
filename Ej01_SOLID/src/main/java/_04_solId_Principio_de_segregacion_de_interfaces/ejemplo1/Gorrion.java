package _04_solId_Principio_de_segregacion_de_interfaces.ejemplo1;

public class Gorrion implements Pajaro{

	public void volar() {
		System.out.println("Soy el gorri�n y vuelo");
	}
	
	public void nadar() {
		throw new RuntimeException("Soy el gorri�n y me ahogo");
	}
	
	public void andar() {
		System.out.println("Soy el gorri�n y ando");
	}
	
	public void voz() {
		System.out.println("Soy el gorri�n y pio pio");
	}
	
}
