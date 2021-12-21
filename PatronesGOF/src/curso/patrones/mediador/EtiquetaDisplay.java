package curso.patrones.mediador;

import java.awt.Font;

import javax.swing.JLabel;

public class EtiquetaDisplay extends JLabel{
	private IMediador mediador;
	public EtiquetaDisplay(IMediador mediador) {
		super("Iniciando");
		this.mediador = mediador;
		mediador.registrarDisplay(this);
		setFont(new Font("Arial", Font.BOLD, 24));
	}
}
