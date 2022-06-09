package com.curso;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteIntrinseco {

	private static SpriteIntrinseco instancia = new SpriteIntrinseco();
	
	public static SpriteIntrinseco getInstancia() {
		return instancia;
	}

	private BufferedImage image;

	private SpriteIntrinseco() {
		loadImage();
	}

	private void loadImage() {
        try {
			image = ImageIO.read(new File("imagenes/cpc464.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Image getImage() {
		return image;
	}


}