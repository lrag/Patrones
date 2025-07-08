package _02_sOlid_Principio_de_abierto_cerrado_ejemplo1;

//
//Esta interfaz es la 'clase que se queda cerrada'
//Está abierta a la extensión porque en cualquier momento podemos programar una nueva
//manera de enviar mensajes implementando esta interfaz (o heredando si fuera una clase)
//
public interface EmisorMensajes {

	//No deberíamos colocar más de tres parámetros en un método
	void enviarMensaje(Mensaje mensaje);
	
}
