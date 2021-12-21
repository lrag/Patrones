package curso.patrones.fachada;

public class Programa {
	public static void main(String[] args) {
		DVD dvd =new DVD();
		TV tv=new TV();
		EquipoHIFI equipoHIFI=new EquipoHIFI();
		MandoProgramableFachada mandoProgramable=new MandoProgramableFachada(tv,equipoHIFI,dvd);
		
		//vamos a ver una peli
		mandoProgramable.ponerPeli();
		
		System.out.println("dos horas despues");
		
		mandoProgramable.ponerPeli();
		
	}
}
