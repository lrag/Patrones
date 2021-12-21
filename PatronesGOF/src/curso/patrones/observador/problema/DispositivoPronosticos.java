package curso.patrones.observador.problema;

public class DispositivoPronosticos {
	private float presionAnterior=0;
	private float presionActual=780;
	
	public void poner(float temperatura, float presion, float humedad) {
		presionAnterior=presionActual;
		presionActual=presion;
		pronosticar();
	}

	public void pronosticar() {
		if(presionActual>presionAnterior){
			System.out.println("mejora el tiempo");
		}else if(presionActual==presionAnterior){
			System.out.println("seguimos igual");
		}else if(presionActual<presionAnterior){
			System.out.println("saca el paraguas");
		}
		
	}
}
