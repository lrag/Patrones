package curso.patrones.singleton;

public class Singleton {
	//si lo pongo asi inicializando el miembro estatico sólo puedo poner el new.
	//private static Singleton instancia=new Singleton();
	
	private static Singleton instancia;
	
	static{
		//en el inicializador estatico de la clase puedo poner todas las instrucciones
		//que quiera ejecutar sólo una vez y de forma thread safe al cargar la clase
		instancia=new Singleton();
	}
	
	private Singleton() {}

	public static Singleton getInstancia() {
		return instancia;
	}
	
	
}
