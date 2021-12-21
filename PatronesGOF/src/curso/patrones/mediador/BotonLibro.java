package curso.patrones.mediador;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BotonLibro extends JButton implements Comando {	
	IMediador mediador;
	public BotonLibro(ActionListener listener, IMediador mediador){
		super("Vista");
		addActionListener(listener);
		this.mediador = mediador;
		mediador.registrarLibro(this);
	}
	@Override
	public void ejecutar() {
		mediador.libro();
		
	}	
}
