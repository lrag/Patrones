package _05_soliD_Principio_de_inversion_de_dependencias;

public class FactoriaClienteDao {

	public static ClienteDao getClienteDao() {
		
		ClienteDao clienteDao = null;
		String tipoBBDD = "mongodb"; //Esto lo habríamos leído de un fichero de configuracion
		if(tipoBBDD.equals("mongodb")) {
			clienteDao = new ClienteDaoMongoDBImplementation();
		} else if(tipoBBDD.equals("mysql")) {
			clienteDao = new ClienteDaoMysqlImplementation();
		}		
		return clienteDao;
		
	}

}
