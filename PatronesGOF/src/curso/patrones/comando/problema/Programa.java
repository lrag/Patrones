package curso.patrones.comando.problema;

public class Programa {
	public static void main(String[] args) {
		MandoUniversal mando=new MandoUniversal();
		mando.pulsarOn(1);
		mando.pulsarOff(2);
		mando.pulsarOff(1);
	}
}
