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
			default: throw new RuntimeException("Método no soportado");
		}
		
	}
	
	//Si lo huberamos hecho así también estaríamos dejando esta clase abierta
	//Pero estaríamos respetando la S
	public void enviarMensaje_BIS(String destinatario, String texto, String tipo) {

		//Tantas cosas aqui...
		switch(tipo) {
			case "SMS" :
				enviarMensajeSMS();
				break;		
			case "CorreoE" :
				enviarMensajeCorreoE();
				break;		
			case "Paloma mensajera" :
				enviarMensajePalomaMensajera();
				break;	
			default: throw new RuntimeException("Método no soportado");
		}
		
	}	
		
	public void enviarMensajeSMS() {
		
	}
	
	public void enviarMensajeCorreoE() {
		
	}
	
	public void enviarMensajePalomaMensajera() {
		
	}
	
	
}
