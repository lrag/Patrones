package curso.patrones.singleton.ejemploFabricaDao;

public class FabricaCosaDao {
	private static FabricaCosaDao instance;
	
	static{
		instance=new FabricaCosaDao();
	}
	
	private	FabricaCosaDao(){}
	
	public static FabricaCosaDao getInstance() {
		return instance;
	}

	public CosaDao getDao() {
		if(System.getenv("DB2")!=null){
			return new CosaDaoDB2Impl();
		}else{
			return new CosaDaoOracleImpl();
		}
	}
	
	

}
