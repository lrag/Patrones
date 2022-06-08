package com.curso.imagenes.util;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
 
//Este lee el fichero original
//No recibe la imagen de ningún eslabón anterior:
//
public class FileImageReader extends AbstractImageReader {
	
	private String fichero;
	
	public FileImageReader() {
		//No damos un valor al 'anterior eslabon' 
		//porque ImageReader es el primero de la cadena
		super(null);
	}

	public FileImageReader(String fichero) {
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