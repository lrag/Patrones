package curso.patrones.puente.problema;

public class Programa {
	public static void main(String[] args) {
		SoporteTecnico soporte=new SoporteTecnico();
		UsuarioSistemas usuarioSistemas=new UsuarioSistemas("no puedo hacer login?");
		usuarioSistemas.reponderPreguntaSistemas(usuarioSistemas.pregunta);
		UsuarioDesarrollo usuarioDesarrollo=new UsuarioDesarrollo("que son los patrones?");
		usuarioDesarrollo.reponderPreguntaDesarrollo(usuarioDesarrollo.pregunta);
	}
}
