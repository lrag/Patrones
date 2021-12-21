package curso.patrones.singleton.ejemploFabricaDao;

import java.util.List;

public interface CosaDao {
	public void guardar(Cosa c);
	public void borrar(Cosa c);
	public List listar();
	public Cosa buscar(String valor);
}
