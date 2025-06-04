package _05_soliD_Principio_de_inversion_de_dependencias;

public class ServicioClientes_2 {

	//Ahora no estamos acoplando la clase de alto nivel con la de bajo nivel
	//sino con una interfaz. Estamos respetando el principio de inversion de dependencias
	//Si las posibles implementaciones respetan el principio de sustitución de Liskov 
	//pues entonces ideal
	
	//Retiramos la responsabilidad de crear el objeto
	//Esto es IoC. Ahora el que sabe crear ClienteDao es otro
	//Seguimos con los problemas para hacer test doubles
	private ClienteDao clienteDao = FactoriaClienteDao.getClienteDao();
	
	public ServicioClientes_2(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}
	
	public void altaCliente(Cliente cliente) {
		System.out.println("Validando la dirección");
		System.out.println("Buscando una sucursal");
		System.out.println("Asignando un comercial");
		clienteDao.insertar(cliente);		
	}
	
}
