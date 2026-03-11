package _05_soliD_Principio_de_inversion_de_dependencias;

//ServicioClientes es una clase de alto nivel
//Depende de ClienteDao, que es de bajo nivel
//Tiene una relación de uso, no de composición
public class ServicioClientes_2 {

	//Esto es quedarnos tan a medias que es como si no hubieramos hecho nada
	/*
	private ClienteDao clienteDao = new ClienteDaoMysqlImplementation();
	
	public ServicioClientes_2() {
		super();
	}
	*/
	
	
	//Esto está cumpliendo la D pero con ese código en el constructor le añadimos
	//a ServicioClientes la responsabilidad de obtener sus dependencias
	/*
	private ClienteDao clienteDao;
		
	public ServicioClientes_2() {
		//Este código no está 'cerrado'
		String tipoBBDD = "mongodb"; //Esto lo habríamos leído de un fichero de configuracion
		if(tipoBBDD.equals("mongodb")) {
			clienteDao = new ClienteDaoMongoDBImplementation();
		} else if(tipoBBDD.equals("mysql")) {
			clienteDao = new ClienteDaoMysqlImplementation();
		}
	}
	*/
	
	
	//Ahora no estamos acoplando la clase de alto nivel con la de bajo nivel
	//sino con una interfaz. Estamos respetando el principio de inversion de dependencias
	//Si las posibles implementaciones respetan el principio de sustitución de Liskov 
	//pues entonces ideal	

	//Con la llamada a la factoría no quitamos del todo la responsabilidad
	//que tiene ServicioClientes de obtener sus dependecias pero casi casi
	private ClienteDao clienteDao = FactoriaClienteDao.getClienteDao();

	public ServicioClientes_2() {
	}
	
	//PAra poder hacer test unitarios debemos añadir este métodito
	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}
	
	public void altaCliente(Cliente cliente) {
		System.out.println("Validando la dirección");
		System.out.println("Buscando una sucursal");
		System.out.println("Asignando un comercial");
		clienteDao.insertar(cliente);		
	}
	
}
