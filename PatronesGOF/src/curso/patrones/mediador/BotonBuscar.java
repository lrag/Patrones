package curso.patrones.mediador;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BotonBuscar extends JButton implements Comando {	
	IMediador mediador;
	public BotonBuscar(ActionListener listener, IMediador mediador){
		super("Vista");
		addActionListener(listener);
		this.mediador = mediador;
		mediador.registrarBusqueda(this);
	}
	@Override
	public void ejecutar() {
		mediador.buscar();
		
	}	
}
