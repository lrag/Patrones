package _02_sOlid_Principio_de_abierto_cerrado_ejemplo1;

public class Aplicacion {

	public static void main(String[] args) {
		
		System.out.println("===============================================");
		EmisorMensajes_MAL emm = new EmisorMensajes_MAL();
		emm.enviarMensaje("Fistro", "Te digo trigo por no llamarte Rodrigo", "SMS");
		emm.enviarMensaje("Fistro", "Te digo trigo por no llamarte Rodrigo", "CorreoE");
		
		System.out.println("===============================================");
		Mensaje m = new Mensaje("Torpedo", "Siete caballos vienen de bonanza");
		EmisorMensajes em1 = new EmisorMensajesSMS();
		EmisorMensajes em2 = new EmisorMensajesCorreoE();
		EmisorMensajes em3 = new EmisorMensajesPalomaMensajera();
		
		em1.enviarMensaje(m);
		em2.enviarMensaje(m);
		em3.enviarMensaje(m);

	}
	
}
