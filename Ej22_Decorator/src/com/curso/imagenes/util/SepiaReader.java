package com.curso.imagenes.util;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
  
public class SepiaReader extends AbstractImageReader {
	
	public SepiaReader(AbstractImageReader imageReader) {
		super(imageReader);
	}

	@Override
	public BufferedImage read() throws IOException {

		BufferedImage imagen = super.imageReader.read();
		
        // get image's width and height
        int width = imagen.getWidth();
        int height = imagen.getHeight();
  
        //converting to sepia
        for(int y = 0; y < height; y++)
        {
          for(int x = 0; x < width; x++)
          {
            int p = imagen.getRGB(x,y);
            int a = (p>>24) & 0xff;
            int R = (p>>16) & 0xff;
            int G = (p>>8) & 0xff;
            int B = p & 0xff;

            int newR = (int)(0.393*R + 0.769*G + 0.189*B);
            int newG = (int)(0.349*R + 0.686*G + 0.168*B);
            int newB = (int)(0.272*R + 0.534*G + 0.131*B);
            if (newR > 255) {
              R = 255;
            } else {
              R = newR;
            }

            if (newG > 255) {
              G = 255;
            } else {
              G = newG;
            }

            if (newB > 255) {
              B = 255;
            } else {
              B = newB;
            } 

            p = (a<<24) | (R<<16) | (G<<8) | B;
            imagen.setRGB(x, y, p);
          }
        }
  
        return imagen;        
    }

}