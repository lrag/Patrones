package _05_soliD_Principio_de_inversion_de_dependencias;

public class ClienteDaoMysqlImplementation implements ClienteDao{

	public void insertar(Cliente cliente) {
		System.out.println("Insertando en ClienteDao (mysql):"+cliente);
	}

	@Override
	public void modificar(Cliente cliente) {
	}

	@Override
	public void borrar(Cliente cliente) {
	}

	@Override
	public void listar(String criterio) {
	}

	@Override
	public void buscarPorId(Integer id) {
	}
	
}
