package curso.patrones.decorador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Pruebas {

	public static void main(String[] args) throws IOException  {
		
		
		FileWriter fw = new FileWriter("fichero.txt");
		//fw.write("Hola que tal");
		
		
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("HOLA");
		bw.write("QUE");
		bw.write("TAL");
		
		bw.flush();
		
		fw.close();
		
	}
	
}
