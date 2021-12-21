package curso.patrones.observador;

public class Programa {
	public static void main(String[] args) {
		DispositivoMedidasActuales medidasActuales=new DispositivoMedidasActuales();
		DispositivoEstadisticas estadisticas=new DispositivoEstadisticas();
		DispositivoPronosticos pronosticos=new DispositivoPronosticos();
		DatosDelTiempo datosDelTiempo=new DatosDelTiempo();
		datosDelTiempo.registrarObservador(medidasActuales);
		datosDelTiempo.registrarObservador(estadisticas);
		datosDelTiempo.registrarObservador(pronosticos);
		//ya esta armado el sistema ahora empezamos a recibir datos 
		//desde el sensor
		
		datosDelTiempo.ponMuestra(33, 850, 60);
		System.out.println("-------------5 secs------------");
		datosDelTiempo.ponMuestra(34, 820, 65);
		System.out.println("-------------5 secs------------");
		datosDelTiempo.ponMuestra(35, 840, 68);
		System.out.println("-------------5 secs------------");
		System.out.println("quitamos observadores o podriamos poner nuevos");
		datosDelTiempo.borrarObservador(pronosticos);
		datosDelTiempo.ponMuestra(35, 870, 68);
		System.out.println("-------------5 secs------------");
	}
}
