package _05_soliD_Principio_de_inversion_de_dependencias_parte1;

//ServicioClientes es una clase de alto nivel
//Depende de ClienteDao, que es de bajo nivel
//Tiene una relación de uso, no de composición
public class ServicioClientes_1 {

	//Crear objetos con new en vez de simple es simplón
	//A ver quien hace un test double de esto...
	private ClienteDao clienteDao = new ClienteDao();
	
	public void altaCliente(Cliente cliente) {
		System.out.println("Validando la dirección");
		System.out.println("Buscando una sucursal");
		System.out.println("Asignando un comercial");
		clienteDao.insertar(cliente);		
	}
	
}
