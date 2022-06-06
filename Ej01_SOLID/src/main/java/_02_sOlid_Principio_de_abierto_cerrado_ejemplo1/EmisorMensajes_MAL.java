package _02_sOlid_Principio_de_abierto_cerrado_ejemplo1;

public class EmisorMensajes_MAL {

	public void enviarMensaje(String destinatario, String texto, String tipo) {

		//Tantas cosas aqui...
		switch(tipo) {
			case "SMS" :
				System.out.println("Enviando SMS a "+destinatario);
				break;		
			case "CorreoE" :
				System.out.println("Enviando CorreoE a "+destinatario);
				break;		
			case "Paloma mensajera" :
				System.out.println("Enviando una paloma mensajera a "+destinatario);
				break;		
		}
		
	}
	
}
