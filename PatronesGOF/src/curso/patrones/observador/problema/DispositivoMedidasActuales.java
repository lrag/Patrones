package curso.patrones.observador.problema;

public class DispositivoMedidasActuales {
	private float temperatura;
	private float presion;
	private float humedad;
	
	public void actualizar(float temperatura, float presion, float humedad) {
		this.temperatura = temperatura;
		this.presion = presion;
		this.humedad = humedad;
		mostrar();
	}
	
	public void mostrar(){
		System.out.println("las temperatura actual es "+temperatura+" Cº, con" +
				" una humedad de "+humedad+" % y una presion de "+presion+" mm");
	}
}
