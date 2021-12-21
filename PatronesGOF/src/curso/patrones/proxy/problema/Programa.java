package curso.patrones.proxy.problema;

public class Programa {
	public static void main(String[] args) {
		//estamos todas las veces releyendo el fichero desde el disco
		OperacionesConFichero operaciones=new OperacionesConFichero("proxy_fichero.txt");
		operaciones.abrir();
		int contador=0;
		do {
			String linea = operaciones.leerLinea();
			while (linea != null) {
				System.out.println(linea);
				linea = operaciones.leerLinea();
			}
			operaciones.rebobinar();
		} while (contador++<3);
		operaciones.cerrar();
	}
}
