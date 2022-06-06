package _01_Solid_Principio_de_responsabilidad_unica.ejemplo2;

public class ServicioClientes {

	// :(
	private EntityManager em = new EntityManager();
	
	private ClienteDao clienteDao = new ClienteDao();
	
	public void altaCliente_MAL(Cliente cliente) {
		//Validar la dirección
		//Encontrar sucursal cercana
		//Asociarle un comercial...		
		em.persist(cliente);		
	}

	public void altaCliente(Cliente cliente) {
		//Validar la dirección
		//Encontrar sucursal cercana
		//Asociarle un comercial...		
		clienteDao.insertar(cliente);		
	}
	
}
