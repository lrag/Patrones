package com.curso.imagenes.util;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
  
public class EscalaGrisesReader extends AbstractImageReader {
	
	public EscalaGrisesReader(AbstractImageReader imageReader) {
		super(imageReader);
	}

	@Override
	public BufferedImage read() throws IOException {

		BufferedImage imagen = super.imageReader.read();
		
        // get image's width and height
        int width = imagen.getWidth();
        int height = imagen.getHeight();
  
        // convert to grayscale
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                
                // Here (x,y)denotes the coordinate of image
                // for modifying the pixel value.
                int p = imagen.getRGB(x, y);
  
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;
  
                // calculate average
                int avg = (r + g + b) / 3;
  
                // replace RGB value with avg
                p = (a << 24) | (avg << 16) | (avg << 8)
                    | avg;
  
                imagen.setRGB(x, y, p);
            }
        }
  
        return imagen;        
    }

}