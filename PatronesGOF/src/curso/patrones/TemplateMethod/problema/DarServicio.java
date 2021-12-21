package curso.patrones.TemplateMethod.problema;

public abstract class DarServicio {
	//el algoritmo esta en todas las subclases de manera que esta
	//duplicado en todas ellas lo que dificulta asegurar su cumplimento,
	//y sus futuras modificaciones.
	abstract void tareas();
	
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
