package com.curso.imagenes.util;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
  
public class EspejoReader extends AbstractImageReader {
	
	public EspejoReader(AbstractImageReader imageReader) {
		super(imageReader);
	}

	@Override
	public BufferedImage read() throws IOException {

		BufferedImage imagen = super.imageReader.read();
		
		// Get source image dimension
        int width = imagen.getWidth();
        int height = imagen.getHeight();
  
        // BufferedImage for mirror image
        BufferedImage espejo = new BufferedImage(
            width, height, BufferedImage.TYPE_INT_RGB);
  
        // Create mirror image pixel by pixel
        for (int y = 0; y < height; y++) {
            for (int lx = 0, rx = width - 1; lx < width; lx++, rx--) {
                  
                  // lx starts from the left side of the image
                // rx starts from the right side of the
                // image lx is used since we are getting
                // pixel from left side rx is used to set
                // from right side get source pixel value
                int p = imagen.getRGB(lx, y);
  
                // set mirror image pixel value
                espejo.setRGB(rx, y, p);
            }
        }
        
        return espejo;        
    }

}