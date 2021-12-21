package curso.patrones.proxy;

import java.util.ArrayList;
import java.util.List;

public class OperacionesConFicheroProxy implements OperacionesConFichero {
	OperacionesConFichero conFichero;
	List lineas;
	int pos=0;
	
	public OperacionesConFicheroProxy(OperacionesConFichero conFichero) {
		this.conFichero = conFichero;
	}

	public void abrir() {
		lineas=new ArrayList();
		conFichero.abrir();
		pos=0;
	}

	public void cerrar() {
		conFichero.cerrar();
		lineas=null;
		pos=0;
	}

	public String leerLinea() {
		pos++;
		if(lineas!=null&&pos<lineas.size())
			return (String) lineas.get(pos);
		else{
			String linea = conFichero.leerLinea();
			lineas.add(linea);
			return linea;
		}
	}

	public void rebobinar() {
		pos=0;

	}

}
