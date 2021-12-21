package curso.patrones.TemplateMethod.problema;

public class DarSoporte extends DarServicio{
	void tareas(){
		presentarOferta();
		revisarIncidencias();
		resolverIncidencias();
		hacerEncuestas();
		mandarFactura();
	}

	void resolverIncidencias() {
		System.out.println("resolverIncidencias");
		
	}

	void revisarIncidencias() {
		System.out.println("revisarIncidencias");
		
	}


}
