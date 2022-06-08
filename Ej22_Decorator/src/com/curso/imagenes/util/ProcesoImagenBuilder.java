package com.curso.imagenes.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ProcesoImagenBuilder {

	//Esto hay que cambiarlo por un enum 
	public static final String AZUL = "Azul";
	public static final String VERDE = "Verde";
	public static final String ROJO = "Rojo";
	public static final String ESPEJO = "Espejo";
	public static final String ESCALA_GRISES = "EscalaGrises";
	public static final String NEGATIVO = "Negativo";
	public static final String SEPIA = "Sepia";
	
	private AbstractImageReader abstractReader;

	public ProcesoImagenBuilder(String fichero) {
		super();
		abstractReader = new FileImageReader(fichero);
	}
	
	public ProcesoImagenBuilder addProceso(String reader) throws Exception {
		Constructor constructor = Class.forName("com.curso.imagenes.util."+reader+"Reader").getConstructor(AbstractImageReader.class);
		abstractReader = (AbstractImageReader) constructor.newInstance(abstractReader);
		return this;
	}

	public AbstractImageReader build() {
		return abstractReader;
	}
	
}
