package curso.patrones.singleton.ejemploFabricaDao;

//este es el JavaBean
public class Cosa {
	private String valor;
	
	public Cosa() {
	
	}

	public Cosa(String string) {
		valor=string;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}
