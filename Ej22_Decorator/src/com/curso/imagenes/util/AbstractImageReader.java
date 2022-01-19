package com.curso.imagenes.util;

import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class AbstractImageReader {

	protected AbstractImageReader imageReader;
	
	public AbstractImageReader(AbstractImageReader imageReader) {
		super();
		this.imageReader = imageReader;
	}

	public abstract BufferedImage read() throws IOException;
	
}
