package _05_soliD_Principio_de_inversion_de_dependencias;

import java.util.List;

public interface ClienteDao {

	void insertar(Cliente cliente);
	void modificar(Cliente cliente);
	void borrar(Cliente cliente);
	List<Cliente> listar(String criterio);
	Cliente buscarPorId(Integer id);
	
}
