package _04_solId_Principio_de_segregacion_de_interfaces.ejemplo_Solucion;

public class Gallina implements Pajaro, Andador{

	public void andar() {
		System.out.println("Soy la gallina y ando");
	}
	
	public void voz() {
		System.out.println("Soy la gallina y digo cooo cocococo");
	}
	
}
