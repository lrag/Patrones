package curso.patrones.fabrica.AbstractFactory;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CajaRoja extends JTextField {
	public CajaRoja(String text) {
		super(text);
		setForeground(Color.red);
		
	}
}
