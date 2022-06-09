package com.curso.problema;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {

	private int x = 40;
	private int y = 60;
	private BufferedImage image;

	public Sprite() {
		loadImage();
	}

	private void loadImage() {
        try {
			image = ImageIO.read(new File("imagenes/cpc464.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getImage() {
		return image;
	}

}