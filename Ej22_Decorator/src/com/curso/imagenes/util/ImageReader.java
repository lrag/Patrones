package com.curso.imagenes.util;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
  
public class ImageReader extends AbstractImageReader {
	
	private String fichero;
	
	public ImageReader() {
		super(null);
	}

	public ImageReader(String fichero) {
		super(null);
		this.fichero = fichero;
	}

	public BufferedImage read() throws IOException {
        
		System.out.println("Leyendo");
		
        BufferedImage imagen = null;
        File f = null;
  
        // read image
        try {
            f = new File(fichero);
            imagen = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imagen;
    } 
} 