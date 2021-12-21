package curso.patrones.fabrica.AbstractFactory;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public interface FabricaControlesVentana {
	public String crearTitulo();
	public JLabel crearEtiqueta();
	public JTextField crearCaja();
	public JButton crearBoton();
}
