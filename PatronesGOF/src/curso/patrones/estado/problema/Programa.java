package curso.patrones.estado.problema;

public class Programa {
	public static void main(String[] args) {
		MaquinaBebidas maquina=new MaquinaBebidas(2);
		System.out.println(maquina);
		maquina.devolverMoneda();
		maquina.dispensar();
		maquina.insertarMoneda();
		maquina.dispensar();
		maquina.pulsarBoton();
		System.out.println(maquina);
		maquina.insertarMoneda();
		maquina.pulsarBoton();
		System.out.println(maquina);
		maquina.reponer(3);
		System.out.println(maquina);
	}
}
