package curso.patrones.comando;

public class ProgramaSimple {
	public static void main(String[] args) {
		Luz luz=new Luz("cocina");
		EncerderLuzCmd encerderLuzCmd=new EncerderLuzCmd(luz);
		ApagarLuzCmd apagarLuzCmd=new ApagarLuzCmd(luz);
		MandoSimple mando=new MandoSimple(encerderLuzCmd,apagarLuzCmd);
		mando.pulsarOn();
		mando.pulsarOff();

	}
}
