package com.curso.imagenes.util;
import java.awt.image.BufferedImage;
import java.io.IOException;
  
public class AzulReader extends AbstractImageReader {
	
	public AzulReader(AbstractImageReader imageReader) {
		super(imageReader);
	}

	@Override
	public BufferedImage read() throws IOException {

		BufferedImage imagen = super.imageReader.read();
		
        // get image's width and height
        int width = imagen.getWidth();
        int height = imagen.getHeight();
  
        // convert to blue image
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = imagen.getRGB(x, y);
  
                int a = (p >> 24) & 0xff;
                int b = p & 0xff;
  
                // set new RGB
                // keeping the b value same as in original
                // image and setting r and g as 0.
                p = (a << 24) | (0 << 16) | (0 << 8) | b;
  
                imagen.setRGB(x, y, p);
            }
        }
  
        return imagen;        
    }

}