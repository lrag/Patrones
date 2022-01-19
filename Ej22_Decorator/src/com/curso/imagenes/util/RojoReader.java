package com.curso.imagenes.util;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
  
public class RojoReader extends AbstractImageReader {
	
	public RojoReader(AbstractImageReader imageReader) {
		super(imageReader);
	}

	@Override
	public BufferedImage read() throws IOException {

		BufferedImage imagen = super.imageReader.read();
		
        // get image's width and height
        int width = imagen.getWidth();
        int height = imagen.getHeight();
  
        // convert to red image
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = imagen.getRGB(x, y);
  
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
  
                // set new RGB keeping the r
                // value same as in original image
                // and setting g and b as 0.
                p = (a << 24) | (r << 16) | (0 << 8) | 0;
  
                imagen.setRGB(x, y, p);
            }
        }
  
        return imagen;        
    }

}