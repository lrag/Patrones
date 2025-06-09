package _04_solId_Principio_de_segregacion_de_interfaces.ejemplo;

public class Pato implements Pajaro{

	public void volar() {
		System.out.println("Soy el pato y vuelo!");
	}
	
	public void nadar() {
		System.out.println("Soy el pato y nado");
	}
	
	public void andar() {
		System.out.println("Soy el pato y ando");
	}
	
	public void voz() {
		System.out.println("Soy el pato y digo cuac cuac");
	}
	
}
