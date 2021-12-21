package curso.patrones.fabrica.AbstractFactory;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ventana extends JFrame{
	
	private FabricaControlesVentana fabrica;

	public Ventana(FabricaControlesVentana fabrica ) {
		super(fabrica.crearTitulo());
		this.fabrica=fabrica;
		setSize(200,75);
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(fabrica.crearEtiqueta());
		getContentPane().add(fabrica.crearCaja());
		getContentPane().add(fabrica.crearBoton());
		setVisible(true);
	}

}
