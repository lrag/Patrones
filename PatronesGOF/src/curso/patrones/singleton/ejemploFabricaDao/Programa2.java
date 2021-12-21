package curso.patrones.singleton.ejemploFabricaDao;

public class Programa2 {
public static void main(String[] args) {
	//tenemos una cosa el muchos puntos de programa
	Cosa c=new Cosa("hola");
	//queremos hacer una operacion de BBDD con ella vía DAO
	//Nos acordamos que esta aplicacion trabaja contra DB2
	CosaDao dao=FabricaCosaDao.getInstance().getDao();
	dao.guardar(c);
	//Este codigo es dependiente de la implementacion del Dao y al cambiar de 
	//BBDD tendremos que buscar y reemplazar el DAO concreto con el nuevo DAO
	//Solucion FABRICA de DAOS
	
}
}
