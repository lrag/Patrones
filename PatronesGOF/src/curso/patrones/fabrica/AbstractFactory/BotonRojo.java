package curso.patrones.fabrica.AbstractFactory;

import java.awt.Color;

import javax.swing.JButton;

public class BotonRojo extends JButton {
	public BotonRojo(String text) {
		super(text);
		setBackground(Color.red);
		
	}
}
