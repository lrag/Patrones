package curso.patrones.decorador.java.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Programa {
	public static void main(String[] args) throws IOException {
		FileReader reader=new FileReader("c:\\boot.ini");
		BufferedReader bufferedReader=new BufferedReader(reader);
		LineNumberReader lineNumberReader=new LineNumberReader(bufferedReader);
		while(lineNumberReader.ready()){
			//System.out.print((char)reader.read());
			System.out.print(lineNumberReader.getLineNumber()+":"+lineNumberReader.readLine());
		}
		bufferedReader.close();
		
	}
}
