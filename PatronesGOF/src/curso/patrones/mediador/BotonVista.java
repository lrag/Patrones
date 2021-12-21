package curso.patrones.mediador;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BotonVista extends JButton implements Comando {

	IMediador mediador;
	public BotonVista(ActionListener listener, IMediador mediador){
		super("Vista");
		addActionListener(listener);
		this.mediador = mediador;
		mediador.registrarVista(this);
	}
	@Override
	public void ejecutar() {
		mediador.ver();
		
	}	

}
