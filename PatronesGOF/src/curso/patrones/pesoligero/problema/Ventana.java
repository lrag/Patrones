package curso.patrones.pesoligero.problema;

import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JFrame;

public class Ventana extends JFrame{
	public Ventana() {
		super();
		long t_ini=System.currentTimeMillis();
		setSize(1000,550);
		getContentPane().setLayout(new FlowLayout());
		for(int i=0;i<100000;i++){
			int x=(int)(Math.random()*10);
			int y=(int)(Math.random()*50);
			int r=(int)(Math.random()*10);
			Circulo c=new Circulo(x,y,r);
			getContentPane().add(c);
		}
		
		setVisible(true);
		long t_fin=System.currentTimeMillis();
		System.out.println(t_fin-t_ini+" ms");
	}

	public static void main(String[] args) {
		
		Ventana ventana=new Ventana();
		
		
	}
}
