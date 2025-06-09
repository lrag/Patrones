package _05_soliD_Principio_de_inversion_de_dependencias;

import java.util.ArrayList;
import java.util.List;

//ServicioClientes es una clase de alto nivel
//Depende de ClienteDao, que es de bajo nivel
//Tiene una relaci�n de uso, no de composici�n
public class ServicioClientes_1 {

	//Estamos acoplando ServicioClientes con una implementaci�n concreta de clienteDao
	//
	//Crear objetos con new en vez de simple es simpl�n
	//A ver quien hace un test double de esto...
	//ServicioClientes, adem�s, tiene una responsabilidad que no le corresponde: crear el ClienteDao
	private ClienteDaoMysqlImplementation clienteDao = new ClienteDaoMysqlImplementation();
	
	public void altaCliente(Cliente cliente) {
		System.out.println("Validando la direcci�n");
		System.out.println("Buscando una sucursal");
		System.out.println("Asignando un comercial");
		clienteDao.insertar(cliente);		
	}
	
	public List<Cliente> listarClientes(){
		return new ArrayList<>();
	}
	
}










