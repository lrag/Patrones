package _02_sOlid_Principio_de_abierto_cerrado_ejemplo1;

//
//Esta interfaz es la 'clase que se queda cerrada'
//Est� abierta a la extensi�n porque en cualquier momento podemos programar una nueva
//manera de enviar mensajes implementando esta interfaz (o heredando si fuera una clase)
//
public interface EmisorMensajes {

	//No deber�amos colocar m�s de tres par�metros en un m�todo
	void enviarMensaje(Mensaje mensaje);
	
}
