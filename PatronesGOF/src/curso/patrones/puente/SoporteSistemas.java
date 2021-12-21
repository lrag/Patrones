package curso.patrones.puente;

public class SoporteSistemas extends Soporte {
	public void reponderPreguntaSistemas(String pregunta){
		System.out.println("respondiendo a "+pregunta+" de Sistemas");
	}
	@Override
	public void resolver(String duda) {
		reponderPreguntaSistemas(duda);
	}
}
