package _04_solId_Principio_de_segregacion_de_interfaces.ejemplo1;

public class Gallina implements Pajaro{

	public void volar() {
		throw new RuntimeException("Soy la gallina y no vuelo!");
	}
	
	public void nadar() {
		throw new RuntimeException("Soy la gallina y me ahogo");
	}
	
	public void andar() {
		System.out.println("Soy la gallina y ando");
	}
	
	public void voz() {
		System.out.println("Soy la gallina y digo cooo cocococo");
	}
	
}
