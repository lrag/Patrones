package curso.patrones.TemplateMethod;

public class DarConsultoria extends DarServicio {

	@Override
	void preparacionPrevia() {
		buscarDebilidades();

	}

	private void buscarDebilidades() {
		System.out.println("buscarDebilidades");
		
	}

	@Override
	void realizar() {
		emitirInforme();

	}

	private void emitirInforme() {
		System.out.println("emitir informe");
		
	}

}
