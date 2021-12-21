package curso.patrones.puente;

public class Usuario {
	Soporte soporte;
	
	public Usuario(Soporte soporte) {
		this.soporte = soporte;
	}

	public void resolverDuda(String duda){
		soporte.resolver(duda);
	}
}
