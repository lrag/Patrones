package curso.patrones.proxy.problema;

import java.io.*;

public class OperacionesConFichero {
	String nombre;
	private BufferedReader reader;

	public OperacionesConFichero(String nombre) {
		this.nombre = nombre;
	}
	
	public String leerLinea(){
		String linea=null;
		try {
			if(reader.ready())
				linea=reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return linea;
	}
	
	public void rebobinar(){
		try {
			reader.reset();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void abrir(){
		try {
			reader = new BufferedReader(new FileReader(nombre));
			reader.mark(4096);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void cerrar(){
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 
}
