package curso.patrones.TemplateMethod;

public abstract class DarServicio {
	final void tareas(){
		presentarOferta();
		preparacionPrevia();
		realizar();
		hacerEncuestas();
		mandarFactura();
	}
	
	abstract void realizar() ;

	abstract void preparacionPrevia();

	void mandarFactura() {
		System.out.println("mandarFactura");
		
	}

	void hacerEncuestas() {
		System.out.println("hacerEncuestas");
		
	}


	 void presentarOferta() {
		System.out.println("presentarOferta");
		
	}
}
