package curso.patrones.mediador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Programa extends JFrame implements ActionListener {
	IMediador mediador = new Mediador();
	public Programa(){
		JPanel p = new JPanel();
        p.add(new BotonVista(this, mediador));
        p.add(new BotonLibro(this, mediador));
        p.add(new BotonBuscar(this, mediador));
        getContentPane().add(new EtiquetaDisplay(mediador), "North");
        getContentPane().add(p, "South");
        setSize(400, 200);
        setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Comando comando = (Comando) e.getSource();
		comando.ejecutar();
		
	}
	public static void main(String[] args) {
		new Programa();
	}
}
