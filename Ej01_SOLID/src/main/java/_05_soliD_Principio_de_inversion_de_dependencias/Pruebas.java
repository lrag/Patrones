package _05_soliD_Principio_de_inversion_de_dependencias;

public class Pruebas {

	public static void main(String[] args) {
		
		ClienteDao cDao = FactoriaClienteDao.getClienteDao();
		ServicioClientes_3 sc = new ServicioClientes_3(cDao);
		
		Cliente c = new Cliente();
		sc.altaCliente(c);
		
	}
	
	
}

