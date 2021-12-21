package curso.patrones.comando.problema;

public class MandoUniversal {
	TV tv=new TV();
	Luz luz=new Luz("salon");
	Puerta puerta=new Puerta("garage");
	
	public void pulsarOn(int pos){
		switch (pos) {
		case 0:tv.on();	break;
		case 1:luz.encender();break;
		case 2:puerta.abrir();	break;
		}
	}
	
	public void pulsarOff(int pos){
		switch (pos) {
		case 0:tv.off();break;
		case 1:luz.apagar();break;
		case 2:puerta.cerrar();	break;
		}
	}
}
