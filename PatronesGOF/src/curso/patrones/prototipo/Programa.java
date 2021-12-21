package curso.patrones.prototipo;

import java.awt.Color;

public class Programa {
	public static void main(String[] args) throws CloneNotSupportedException {
		Soldado soldado=new Soldado("capitan",new Color(255,0,0),"pistola");
		
		System.out.println(soldado);
		
		//ojo con los costructores faciles
		//Soldado soldadoCopia=new Soldado(soldado);
		
		//clonacion profunda a mano
		//Soldado soldadoCopia=(Soldado) soldado.clone();
		
		//clonacion profunda vía serializacion/deserializacion
		Soldado soldadoCopia=(Soldado) soldado.clonacionProfunda();
		System.out.println(soldado);
		soldado.poderes.add("inteligencia");
		System.out.println(soldadoCopia.poderes.get(0));
	}
}
