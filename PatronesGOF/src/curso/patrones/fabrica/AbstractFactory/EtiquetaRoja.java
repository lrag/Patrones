package curso.patrones.fabrica.AbstractFactory;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

public class EtiquetaRoja extends JLabel {
	public EtiquetaRoja(String text) {
		super(text);
		setForeground(Color.red);
		
	}
}
