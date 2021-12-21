package curso.patrones.base.adaptador;

public class Pterodactilo extends Dinosaurio {

	@Override
	public void pasarPorElAgua() {
		System.out.println("caminando entre las aguas");

	}

	@Override
	public void rugir() {
		System.out.println("grrrrrrrrrrrrrrrr!!!");

	}

	@Override
	public void volar() {
		System.out.println(" estoy en el aire, ciudado!!!");

	}
	
	@Override
	public String toString() {
		return "soy un pterodactilo";
	}

}
