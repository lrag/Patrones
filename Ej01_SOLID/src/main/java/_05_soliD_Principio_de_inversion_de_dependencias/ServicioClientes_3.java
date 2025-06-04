package _05_soliD_Principio_de_inversion_de_dependencias;

public class ServicioClientes_3 {

	private ClienteDao clienteDao;
	
	//Inyección de dependencias: Esto está bien si tienes un contenedor
	//IoC también
	//Y ya podemos hacer test doubles
	//Y no estamos acoplados con una implementación concreta de ClienteDao
	public ServicioClientes_3(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}
	
	public void altaCliente(Cliente cliente) {
		System.out.println("Validando la dirección");
		System.out.println("Buscando una sucursal");
		System.out.println("Asignando un comercial");
		clienteDao.insertar(cliente);		
	}
	
}

