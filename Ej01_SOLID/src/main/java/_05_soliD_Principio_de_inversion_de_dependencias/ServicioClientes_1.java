package _05_soliD_Principio_de_inversion_de_dependencias;

import java.util.ArrayList;
import java.util.List;

//ServicioClientes es una clase de alto nivel
//Depende de ClienteDao, que es de bajo nivel
//Tiene una relación de uso, no de composición
public class ServicioClientes_1 {

	//Estamos acoplando ServicioClientes con una implementación concreta de clienteDao
	//
	//Crear objetos con new en vez de simple es simplón
	//A ver quien hace un test double de esto...
	//ServicioClientes, además, tiene una responsabilidad que no le corresponde: crear el ClienteDao
	private ClienteDaoMysqlImplementation clienteDao = new ClienteDaoMysqlImplementation();
	
	public void altaCliente(Cliente cliente) {
		System.out.println("Validando la dirección");
		System.out.println("Buscando una sucursal");
		System.out.println("Asignando un comercial");
		clienteDao.insertar(cliente);		
	}
	
	public List<Cliente> listarClientes(){
		return new ArrayList<>();
	}
	
}










