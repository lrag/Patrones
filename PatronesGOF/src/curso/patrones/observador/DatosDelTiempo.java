package curso.patrones.observador;

public class DatosDelTiempo extends Tema{
	private float temperatura;
	private float presion;
	private float humedad;
	
	
	@Override
	public void notificarObservadores() {
		RegistroTiempo registroTiempo = new RegistroTiempo(temperatura,presion,humedad);
		for(Object o:observadores)
			((Observador)o).manejarDatos(null, registroTiempo );
	}
	
	public void ponMuestra(float temperatura, float presion, float humedad) {
		this.temperatura = temperatura;
		this.presion = presion;
		this.humedad = humedad;
		actualidarDatos();
	}
	
	//este el el metodo que va a notificar a los dispositivos de
	//terceros los nuevos valores de las variables
	public void actualidarDatos(){
		notificarObservadores();
	}


	
	
}
