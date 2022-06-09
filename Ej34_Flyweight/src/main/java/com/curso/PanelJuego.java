package com.curso;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class PanelJuego extends JPanel {

	private static final long serialVersionUID = 1L;
	private List<Sprite> sprites = new ArrayList<>();

    public PanelJuego() {
		super();		
	}

	@Override
    public void paintComponent(Graphics g) {
    	System.out.println("==================================");
    	super.paintComponents(g); 

    	sprites.clear();
		for(int x=0; x<this.getWidth(); x=x+50) {
			for( int y=0; y<this.getHeight(); y=y+50) {
				Sprite s = new Sprite();
				s.setX(x);
				s.setY(y);
				sprites.add(s);
			}			
		}    
    	
    	System.out.println(sprites.size());
    	
    	sprites.forEach(s -> g.drawImage(s.getImage(), s.getX(), s.getY(), 50, 50, this));
        Toolkit.getDefaultToolkit().sync();
    }	
    
	
}
