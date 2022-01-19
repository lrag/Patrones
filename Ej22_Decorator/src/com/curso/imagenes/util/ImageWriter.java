package com.curso.imagenes.util;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
  
public class ImageWriter {
	
	private String nombrefichero;
	
	public ImageWriter() {
		super();
	}

	public ImageWriter(String nombrefichero) {
		super();
		this.nombrefichero = nombrefichero;
	}

	public void write(BufferedImage imagen) throws IOException {
  
        try {
            File fichero = new File(nombrefichero);
            ImageIO.write(imagen, "jpg", fichero);
            System.out.println("Writing complete.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    } 

}