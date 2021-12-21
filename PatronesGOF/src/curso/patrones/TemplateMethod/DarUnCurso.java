package curso.patrones.TemplateMethod;

public class DarUnCurso extends DarServicio {

	void impartirCurso() {
		System.out.println("impartirCurso");
		
	}

	void prepararLecciones() {
		System.out.println("prepararLecciones");
		
	}

	@Override
	void preparacionPrevia() {
		prepararLecciones();
		
	}

	@Override
	void realizar() {
		impartirCurso();
		
	}

}
