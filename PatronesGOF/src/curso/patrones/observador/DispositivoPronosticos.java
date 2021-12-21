package curso.patrones.observador;

public class DispositivoPronosticos extends Observador{
	private float presionAnterior=0;
	private float presionActual=780;

	@Override
	public void manejarDatos(Object src, Object data) {
		presionAnterior=presionActual;
		presionActual=((RegistroTiempo)data).getPresion();
		pronosticar();
		
	}
	
	public void pronosticar() {
		if(presionActual>presionAnterior){
			System.out.println("mejora el tiempo");
		}else if(presionActual==presionAnterior){
			System.out.println("seguimos igual");
		}else if(presionActual<presionAnterior){
			System.out.println("saca el paraguas");
		}
		
	}

	
}
