package com.curso.problema;

import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Ventana extends JFrame {

	public Ventana() {	
		setTitle("Swing del bueno");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);

		PanelJuego panel = new PanelJuego();
		this.setContentPane(panel);

	}	
		
}
