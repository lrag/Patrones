package _05_soliD_Principio_de_inversion_de_dependencias;

public class FactoriaClienteDao {

	public static ClienteDao getClienteDao() {
		return new ClienteDaoMysqlImplementation();
	}

}
