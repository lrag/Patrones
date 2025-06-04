package _05_soliD_Principio_de_inversion_de_dependencias;

public class ClienteDaoMongoDBImplementation implements ClienteDao{

	public void insertar(Cliente cliente) {
		System.out.println("Insertando en ClienteDao (mongoDB):"+cliente);
	}
	
}
