package curso.patrones.fachada.problema;

public class Programa {
	public static void main(String[] args) {
		DVD dvd =new DVD();
		TV tv=new TV();
		EquipoHIFI equipoHIFI=new EquipoHIFI();
		//vamos a ver una peli
		dvd.setEncendido(true);
		tv.setEncendido(true);
		equipoHIFI.setEncendido(true);
		dvd.play();
		
		System.out.println("dos horas despues");
		
		dvd.stop();
		dvd.setEncendido(false);
		tv.setEncendido(false);
		equipoHIFI.setEncendido(false);
		
	}
}
