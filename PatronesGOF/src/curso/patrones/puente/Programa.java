package curso.patrones.puente;

public class Programa {
	public static void main(String[] args) {
		Soporte soporte1=new SoporteSistemas();
		Soporte soporte2=new SoporteAplicaciones();
		Soporte soporte3=new SoporteDesarrollo();
		UsuarioSistemas usuarioSistemas=new UsuarioSistemas(soporte1);
		usuarioSistemas.resolverDuda("no puedo hacer login");
		
		UsuarioDesarrollo usuarioDesarrollo=new UsuarioDesarrollo(soporte3);
		usuarioDesarrollo.resolverDuda("el patron brigde?");
	}
}
