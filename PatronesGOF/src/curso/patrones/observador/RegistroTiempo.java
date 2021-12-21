package curso.patrones.observador;

public class RegistroTiempo {
	private float temperatura;
	private float presion;
	private float humedad;
	
	public RegistroTiempo(float temperatura, float presion, float humedad) {
		this.temperatura = temperatura;
		this.presion = presion;
		this.humedad = humedad;
	}

	public float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}

	public float getPresion() {
		return presion;
	}

	public void setPresion(float presion) {
		this.presion = presion;
	}

	public float getHumedad() {
		return humedad;
	}

	public void setHumedad(float humedad) {
		this.humedad = humedad;
	}

}
