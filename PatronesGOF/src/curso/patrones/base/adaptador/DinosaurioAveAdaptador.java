package curso.patrones.base.adaptador;

public class DinosaurioAveAdaptador extends Ave {
	private Dinosaurio dinosaurio;


	public DinosaurioAveAdaptador(Dinosaurio dinosaurio) {
		this.dinosaurio = dinosaurio;
	}

	@Override
	public void cantar() {
		dinosaurio.rugir();

	}

	@Override
	public void mostrar() {
		dinosaurio.toString();

	}
	
	@Override
	public void nadar() {
		dinosaurio.pasarPorElAgua();
	}
	
	@Override
	public void volar() {
		dinosaurio.volar();
	}

}
