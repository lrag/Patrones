package curso.patrones.puente;

public class SoporteDesarrollo extends Soporte{

	public void reponderPreguntaDesarrollo(String pregunta){
		System.out.println("respondiendo a "+pregunta+" de Desarrollo");
	}
	
	@Override
	public void resolver(String duda) {
		reponderPreguntaDesarrollo(duda);
	}
}
