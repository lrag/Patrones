package curso.patrones.observador.problema;

public class DispositivoEstadisticas {
	private float tMax=Float.MIN_VALUE;
	private float tMin=Float.MAX_VALUE;
	private float sumaTemp=0;
	private int numeroMuestras=0;
	
	public void calcular(float temperatura, float presion, float humedad) {
		if(temperatura>tMax)
			tMax=temperatura;
		if(temperatura<tMin)
			tMin=temperatura;
		sumaTemp+=temperatura;
		numeroMuestras++;
		pintar();
	}
	
	public void pintar(){
		System.out.println("TMAX/TMIN/MEDIA"+tMax+"Cº/"+tMin+"Cº/"+(sumaTemp/numeroMuestras)+"Cº/");
	}
}
