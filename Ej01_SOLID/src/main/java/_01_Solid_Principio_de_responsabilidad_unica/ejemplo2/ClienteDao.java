package _01_Solid_Principio_de_responsabilidad_unica.ejemplo2;

public class ClienteDao {

	private EntityManager em = new EntityManager();
	
	public void insertar(Cliente cliente) {
		em.persist(cliente);
	}
	
}
