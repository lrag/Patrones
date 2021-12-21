package curso.patrones.fabrica.AbstractFactory;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FabricaControlesAzulVentana implements FabricaControlesVentana {

	public JButton crearBoton() {
		JButton button=new JButton("boton");
		button.setBackground(Color.blue);
		return button;
	}

	public JTextField crearCaja() {
		JTextField field=new JTextField("caja");
		field.setForeground(Color.blue);
		return field;
	}

	public JLabel crearEtiqueta() {
		JLabel label=new JLabel("etiqueta");
		label.setForeground(Color.blue);
		return label;
	}

	public String crearTitulo() {
		return "Ventana Azul";
	}

}
