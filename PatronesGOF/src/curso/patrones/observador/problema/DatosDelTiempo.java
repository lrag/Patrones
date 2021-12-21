package curso.patrones.observador.problema;

import curso.patrones.observador.problema.DispositivoEstadisticas;

public class DatosDelTiempo {
	private float temperatura;
	private float presion;
	private float humedad;
	
	private DispositivoMedidasActuales medidasActuales;
	private DispositivoEstadisticas estadisticas;
	private DispositivoPronosticos pronosticos;
	
	public void ponMuestra(float temperatura, float presion, float humedad) {
		this.temperatura = temperatura;
		this.presion = presion;
		this.humedad = humedad;
		actualidarDatos();
	}
	
	//este el el metodo que va a notificar a los dispositivos de
	//terceros los nuevos valores de las variables
	public void actualidarDatos(){
		medidasActuales.actualizar(temperatura, presion, humedad);
		estadisticas.calcular(temperatura, presion, humedad);
		pronosticos.poner(temperatura, presion, humedad);
	}

	public void setMedidasActuales(DispositivoMedidasActuales medidasActuales) {
		this.medidasActuales = medidasActuales;
	}

	public void setEstadisticas(DispositivoEstadisticas estadisticas) {
		this.estadisticas = estadisticas;
	}

	public void setPronosticos(DispositivoPronosticos pronosticos) {
		this.pronosticos = pronosticos;
	}
	
	
}
