package _05_soliD_Principio_de_inversion_de_dependencias_parte2;

public class ClienteDaoMysqlImplementation implements ClienteDao {

	public void insertar(Cliente cliente) {
		System.out.println("Insertando en ClienteDao (mysql):"+cliente);
	}
	
}
