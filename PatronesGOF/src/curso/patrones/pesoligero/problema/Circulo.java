package curso.patrones.pesoligero.problema;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

public class Circulo extends Component{
	int x,y,r;
	
	public Circulo(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}

	public Circulo() {
	
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.blue);
		g.drawOval(x, y, r*2, r+2);
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
