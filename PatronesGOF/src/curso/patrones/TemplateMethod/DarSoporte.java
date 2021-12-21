package curso.patrones.TemplateMethod;

public class DarSoporte extends DarServicio{
	

	void resolverIncidencias() {
		System.out.println("resolverIncidencias");
		
	}

	void revisarIncidencias() {
		System.out.println("revisarIncidencias");
		
	}

	@Override
	void preparacionPrevia() {
		revisarIncidencias();
		
	}

	@Override
	void realizar() {
		resolverIncidencias();
		
	}


}
