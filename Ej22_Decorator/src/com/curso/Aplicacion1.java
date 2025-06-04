package com.curso;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.util.Base64;

public class Aplicacion1 {

	public static void main(String[] args) throws Exception {

		// Ejemplo de decorator en el api de java

		
		FileWriter fw1 = new FileWriter("tocoto.txt"); fw1.write("H");
		fw1.write("O"); 
		fw1.write("L"); 
		fw1.write("A"); 
		fw1.close();
		
		// FileWriterB64 fwB64 = new
		// fwB64.write("H");

		FileOutputStream fos = new FileOutputStream("tocoto.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		OutputStream os = Base64.getEncoder().wrap(bos);
		
		os.write("HOLA QUE TAL \n".getBytes());
		os.write("HOLA RADIOLA \n".getBytes());
		os.write("HOLA RAFFAELLA \n".getBytes());
	
		os.close();
		
	}

}










