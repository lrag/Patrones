package _02_sOlid_Principio_de_abierto_cerrado_ejemplo1;

public class EmisorMensajesPalomaMensajera implements EmisorMensajes{

	@Override
	public void enviarMensaje(Mensaje mensaje) {
		System.out.println("Enviando paloma mensajera: "+mensaje);
	}

}
