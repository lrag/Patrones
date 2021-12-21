package curso.patrones.fabrica.AbstractFactory.problema;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaRoja extends JFrame{
	
	public VentanaRoja() {
		super("Ventana Roja");
		setSize(200,75);
		getContentPane().setLayout(new FlowLayout());
		JLabel label=new JLabel("etiqueta");
		label.setForeground(Color.red);
		getContentPane().add(label);
		JTextField field=new JTextField("caja");
		field.setForeground(Color.red);
		getContentPane().add(field);
		JButton button=new JButton("boton");
		button.setBackground(Color.red);
		getContentPane().add(button);
		setVisible(true);
	}

}
