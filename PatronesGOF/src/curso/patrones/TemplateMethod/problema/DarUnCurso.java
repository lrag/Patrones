package curso.patrones.TemplateMethod.problema;

public class DarUnCurso extends DarServicio {
	void tareas(){
		presentarOferta();
		prepararLecciones();
		impartirCurso();
		hacerEncuestas();
		mandarFactura();
	}

	void impartirCurso() {
		System.out.println("impartirCurso");
		
	}

	void prepararLecciones() {
		System.out.println("prepararLecciones");
		
	}

}
