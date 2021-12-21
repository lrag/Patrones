package curso.patrones.singleton;

public class Singleton2 {
	private static Singleton2 instancia;
	
	private Singleton2() {}

	public synchronized static Singleton2 getInstancia() {
		if(instancia==null){
			instancia=new Singleton2();
		}
		return instancia;
	}
	
	
}
