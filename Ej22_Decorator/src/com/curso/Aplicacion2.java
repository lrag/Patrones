package com.curso;

import java.io.IOException;

import com.curso.imagenes.util.AbstractImageReader;
import com.curso.imagenes.util.EscalaGrisesReader;
import com.curso.imagenes.util.EspejoReader;
import com.curso.imagenes.util.FileImageReader;
import com.curso.imagenes.util.ImageWriter;
import com.curso.imagenes.util.NegativoReader;
import com.curso.imagenes.util.ProcesoImagenBuilder;

public class Aplicacion2 {

	public static void main(String[] args) throws Exception {

		FileImageReader ir = new FileImageReader("imagenes/amiga500.jpg");
		EscalaGrisesReader egr = new EscalaGrisesReader(ir);
		NegativoReader nr = new NegativoReader(egr);
		EspejoReader er = new EspejoReader(nr);
		
		ImageWriter iw = new ImageWriter("imagenesProcesadas/amiga500.jpg");		
		iw.write(er.read());
		
		AbstractImageReader air = null;
		
		air = new ProcesoImagenBuilder("imagenes/atariST.jpg")
				.addProceso(ProcesoImagenBuilder.AZUL)
				.build();
		iw = new ImageWriter("imagenesProcesadas/atariST_1.jpg");
		iw.write(air.read());
		
		air = new ProcesoImagenBuilder("imagenes/atariST.jpg")
				.addProceso(ProcesoImagenBuilder.VERDE)
				.build();
		iw = new ImageWriter("imagenesProcesadas/atariST_2.jpg");
		iw.write(air.read());
		
		air = new ProcesoImagenBuilder("imagenes/atariST.jpg")
				.addProceso(ProcesoImagenBuilder.ROJO)
				.build();
		iw = new ImageWriter("imagenesProcesadas/atariST_3.jpg");
		iw.write(air.read());

		air = new ProcesoImagenBuilder("imagenes/zxSpectrum.jpg")
				.addProceso(ProcesoImagenBuilder.NEGATIVO)
				.addProceso(ProcesoImagenBuilder.ESPEJO)
				.build();
		iw = new ImageWriter("imagenesProcesadas/zxSpectrum.jpg");
		iw.write(air.read());
		
		air = new ProcesoImagenBuilder("imagenes/cassette.jpg")
				.addProceso(ProcesoImagenBuilder.NEGATIVO)
				.addProceso(ProcesoImagenBuilder.ESPEJO)
				.build();
		iw = new ImageWriter("imagenesProcesadas/cassette.jpg");
		iw.write(air.read());

		air = new ProcesoImagenBuilder("imagenes/cpc464.jpg")
				.addProceso(ProcesoImagenBuilder.SEPIA)
				.build();
		iw = new ImageWriter("imagenesProcesadas/cpc464.jpg");
		iw.write(air.read());
				
	}
	
}
