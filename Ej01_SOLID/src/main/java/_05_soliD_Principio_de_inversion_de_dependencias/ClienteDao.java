package _05_soliD_Principio_de_inversion_de_dependencias;

public interface ClienteDao {

	void insertar(Cliente cliente);
	void modificar(Cliente cliente);
	void borrar(Cliente cliente);
	void listar(String criterio);
	void buscarPorId(Integer id);
	
}
