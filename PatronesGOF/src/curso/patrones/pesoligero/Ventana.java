package curso.patrones.pesoligero;

import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JFrame;

public class Ventana extends JFrame{
	public Ventana() {
		super();
		long t_ini=System.currentTimeMillis();
		setSize(1000,550);
		getContentPane().setLayout(new FlowLayout());
		int []x=new int [100000] ;
		int[]y=new int [100000] ;
		int[]r=new int [100000] ;
		for(int i=0;i<100000;i++){
			x[i]=(int)(Math.random()*10);
			y[i]=(int)(Math.random()*50);
			r[i]=(int)(Math.random()*10);
			
			
		}
		CirculosFlyWeight c=new CirculosFlyWeight(x,y,r);
		getContentPane().add(c);
		setVisible(true);
		long t_fin=System.currentTimeMillis();
		System.out.println(t_fin-t_ini+" ms");
	}

	public static void main(String[] args) {
		
		Ventana ventana=new Ventana();
		
	}
}
