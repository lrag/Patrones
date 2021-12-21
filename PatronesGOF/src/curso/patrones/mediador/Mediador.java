package curso.patrones.mediador;

public class Mediador implements IMediador{

	BotonVista botonVista;
	BotonBuscar botonBuscar;
	BotonLibro botonLibro;
	EtiquetaDisplay mostrar;
	@Override
	public void libro() {
		botonLibro.setEnabled(false);
        botonVista.setEnabled(true);
        botonBuscar.setEnabled(true);
        mostrar.setText("Constructor libro");
		
	}

	@Override
	public void ver() {
		botonLibro.setEnabled(true);
        botonVista.setEnabled(false);
        botonBuscar.setEnabled(true);
        mostrar.setText("Constructor vista");
		
	}

	@Override
	public void buscar() {
		botonLibro.setEnabled(true);
        botonVista.setEnabled(true);
        botonBuscar.setEnabled(false);
        mostrar.setText("Constructor buscar");
		
	}

	@Override
	public void registrarVista(BotonVista v) {
		this.botonVista = v;
		
	}

	@Override
	public void registrarBusqueda(BotonBuscar s) {
		this.botonBuscar = s;
		
	}

	@Override
	public void registrarLibro(BotonLibro b) {
		this.botonLibro = b;
		
	}

	@Override
	public void registrarDisplay(EtiquetaDisplay d) {
		this.mostrar = d;
		
	}

}
