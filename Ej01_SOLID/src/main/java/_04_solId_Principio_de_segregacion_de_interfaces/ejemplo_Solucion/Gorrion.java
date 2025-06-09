package _04_solId_Principio_de_segregacion_de_interfaces.ejemplo_Solucion;

public class Gorrion implements Pajaro, Volador, Andador {

	public void volar() {
		System.out.println("Soy el gorrión y vuelo");
	}

	public void andar() {
		System.out.println("Soy la gorrión y ando");
	}
	
	public void voz() {
		System.out.println("Soy la gorrión y pio pio");
	}
	
}
