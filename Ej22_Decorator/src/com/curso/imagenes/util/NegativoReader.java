package com.curso.imagenes.util;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
  
public class NegativoReader extends AbstractImageReader {
	
	public NegativoReader(AbstractImageReader imageReader) {
		super(imageReader);
	}

	@Override
	public BufferedImage read() throws IOException {

		BufferedImage imagen = super.imageReader.read();
		
        // get image's width and height
        int width = imagen.getWidth();
        int height = imagen.getHeight();
  
        // Convert to negative
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = imagen.getRGB(x, y);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;
  
                // subtract RGB from 255
                r = 255 - r;
                g = 255 - g;
                b = 255 - b;
  
                // set new RGB value
                p = (a << 24) | (r << 16) | (g << 8) | b;
                imagen.setRGB(x, y, p);
            }
        }
  
        return imagen;        
    }

}