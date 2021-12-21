package curso.patrones.pesoligero;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

public class CirculosFlyWeight extends Component{
	int []x;
	int[]y;
	int[]r;
	
	public CirculosFlyWeight(int[] x, int[] y, int[] r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}

	public CirculosFlyWeight() {
	
	}
	
	@Override
	public void paint(Graphics g) {
		for(int i=0;i<x.length;i++){
			g.setColor(Color.blue);
			g.drawOval(x[i], y[i], r[i]*2, r[i]+2);
			
		}
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(1000,550);
	}

	@Override
	public String toString() {
		return x+","+y+","+r;
	}
}
