package _01_Solid_Principio_de_responsabilidad_unica.ejemplo2;

import java.util.Arrays;
import java.util.List;

public class Aplicacion {

	public static void main(String[] args) {
		
		System.out.println("=========================================");
		ServicioClientes sc = new ServicioClientes();
		Cliente c = new Cliente(null,"Bart","C/Evergreen Terrace","555");
		
		sc.altaCliente_MAL(c);
		sc.altaCliente(c);
		
	}
	
}
