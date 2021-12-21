package curso.patrones.puente;

public class SoporteAplicaciones extends Soporte{

	public void reponderPreguntaAplicaciones(String pregunta){
		System.out.println("respondiendo a "+pregunta+" de Aplicaciones");
	}
	
	@Override
	public void resolver(String duda) {
		reponderPreguntaAplicaciones(duda);
	}

}
