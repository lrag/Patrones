package curso.patrones.fabrica.AbstractFactory;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FabricaControlesRojosVentana implements FabricaControlesVentana {

	public JButton crearBoton() {
		return new BotonRojo("boton");
	}

	public JTextField crearCaja() {
		return new CajaRoja("caja");
	}

	public JLabel crearEtiqueta() {
		return new EtiquetaRoja("ETIQUETA");
	}

	public String crearTitulo() {
		return "Ventana Roja";
	}

}
