package _05_soliD_Principio_de_inversion_de_dependencias_parte1;

public class ServicioClientes_3 {

	private ClienteDao clienteDao ;
	
	//Esto est� bien si tienes un contenedor
	//IoC tambi�n
	//Y ya podemos hacer test doubles
	public ServicioClientes_3(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}
	
	public void altaCliente(Cliente cliente) {
		System.out.println("Validando la direcci�n");
		System.out.println("Buscando una sucursal");
		System.out.println("Asignando un comercial");
		clienteDao.insertar(cliente);		
	}
	
}
