package com.curso.modelo.negocio;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Ejemplo {
	
	//
	//El método que realiza una tarea y devuelve el resultado lanza una excepción si falla
	//
	
	
	//Método que realiza una tarea pero que no tiene nada que devolver
	public void realizarTarea1() {
	}
	
	//Podemos avisar con un boolean de que ha funcionado o fallado
	//Y si ha fallado por qué ha fallado?
	public boolean realizarTarea2() {
		return true;
	}
	
	//0: todo OK
	//otro valor: indica el error
	//Más complicado que devolverun boolean y no mejora casi nada
	public int realizarTarea3() {
		return 0;
	}
	
	//Devolver un objeto del tipo error
	//Aporta información, pero sigue complicando el código del cliente que llama al método
	public Error realizarTarea4() {
		//if(todo bien)
		//	return null;
		//} else {
			return new Error("No hay existencias del producto nosecual");
		//}
	}
		
	public void leerFichero(){
		try {
			FileReader fr = new FileReader("./datos.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//
	//Los métodos que son void y fallan LANZAN EXCEPCIÓN
	//
	public void leerFichero2() throws FileNotFoundException{
		FileReader fr = new FileReader("./datos.txt");
	}
	
}

class Error {
	String mensaje;
	String YoQueSe;
	
	public Error(String mensaje) {
		super();
		this.mensaje = mensaje;
	}
	
}











