package curso.patrones.fabrica.AbstractFactory.problema;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaAzul extends JFrame{
	
	public VentanaAzul() {
		super("Ventana Azul");
		setSize(200,75);
		getContentPane().setLayout(new FlowLayout());
		JLabel label=new JLabel("etiqueta");
		label.setForeground(Color.blue);
		getContentPane().add(label);
		JTextField field=new JTextField("caja");
		field.setForeground(Color.blue);
		getContentPane().add(field);
		JButton button=new JButton("boton");
		button.setBackground(Color.blue);
		getContentPane().add(button);
		setVisible(true);
	}

}
