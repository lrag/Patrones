package curso.patrones.proxy;

public class Programa {
	public static void main(String[] args) {
		//estamos todas las veces releyendo el fichero desde el disco
		long t_ini=System.currentTimeMillis();
		OperacionesConFichero operaciones=new OperacionesConFicheroImpl("proxy_fichero.txt");
		operaciones.abrir();
		int contador=0;
		do {
			String linea = operaciones.leerLinea();
			while (linea != null) {
				System.out.println(linea);
				linea = operaciones.leerLinea();
			}
			operaciones.rebobinar();
		} while (contador++<10000);
		operaciones.cerrar();
		long t_fin=System.currentTimeMillis();
		System.out.println(t_fin-t_ini+" ms");
	}
}
