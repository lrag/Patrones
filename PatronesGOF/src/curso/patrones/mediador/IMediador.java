package curso.patrones.mediador;

public interface IMediador {
	void libro();
    void ver();
    void buscar();
    void registrarVista(BotonVista v);
    void registrarBusqueda(BotonBuscar s);
    void registrarLibro(BotonLibro b);
    void registrarDisplay(EtiquetaDisplay d);
}
