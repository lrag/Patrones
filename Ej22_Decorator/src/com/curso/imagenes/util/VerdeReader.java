package com.curso.imagenes.util;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
  
public class VerdeReader extends AbstractImageReader {
	
	public VerdeReader(AbstractImageReader imageReader) {
		super(imageReader);
	}

	@Override
	public BufferedImage read() throws IOException {

		BufferedImage imagen = super.imageReader.read();
		
        // get image's width and height
        int width = imagen.getWidth();
        int height = imagen.getHeight();
  
        // convert to green image
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = imagen.getRGB(x, y);
  
                int a = (p >> 24) & 0xff;
                int g = (p >> 8) & 0xff;
  
                // set new RGB
                // keeping the g value same as in original
                // image and setting r and b as 0.
                p = (a << 24) | (0 << 16) | (g << 8) | 0;
  
                imagen.setRGB(x, y, p);
            }
        }
  
        return imagen;        
    }

}