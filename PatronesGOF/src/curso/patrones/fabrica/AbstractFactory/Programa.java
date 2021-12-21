package curso.patrones.fabrica.AbstractFactory;

public class Programa {
	public static void main(String[] args) {
		FabricaControlesVentana fabrica1=new FabricaControlesRojosVentana();
		FabricaControlesVentana fabrica2=new FabricaControlesAzulVentana();
		Ventana ventanaRoja=new Ventana(fabrica1);
		Ventana ventanaAzul=new Ventana(fabrica2);
	}
}
