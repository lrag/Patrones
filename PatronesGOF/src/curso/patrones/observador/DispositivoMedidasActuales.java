package curso.patrones.observador;

public class DispositivoMedidasActuales extends Observador {
	private float temperatura;
	private float presion;
	private float humedad;

	public void mostrar() {
		System.out.println("las temperatura actual es " + temperatura
				+ " Cº, con" + " una humedad de " + humedad
				+ " % y una presion de " + presion + " mm");
	}

	@Override
	public void manejarDatos(Object src, Object data) {
		RegistroTiempo rt = (RegistroTiempo) data;
		this.temperatura = rt.getTemperatura();
		this.presion = rt.getPresion();
		this.humedad = rt.getHumedad();
		mostrar();

	}

}
