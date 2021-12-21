package curso.patrones.comando.app;

import curso.patrones.comando.*;

public class ProgramaLuces {
	public static void main(String[] args) {
		Luz luz1=new Luz("cocina");
		Luz luz2=new Luz("salon");
		Luz luz3=new Luz("baño");
		
		EncerderLuzCmd encerderLuz1Cmd=new EncerderLuzCmd(luz1);
		ApagarLuzCmd apagarLuz1Cmd=new ApagarLuzCmd(luz1);
		EncerderLuzCmd encerderLuz2Cmd=new EncerderLuzCmd(luz2);
		ApagarLuzCmd apagarLuz2Cmd=new ApagarLuzCmd(luz2);
		EncerderLuzCmd encerderLuz3Cmd=new EncerderLuzCmd(luz3);
		ApagarLuzCmd apagarLuz3Cmd=new ApagarLuzCmd(luz3);
		
		MandoProgramable mando=new MandoProgramable();
		mando.setComando(0, encerderLuz1Cmd, apagarLuz1Cmd);
		MacroCmd macroOn=new MacroCmd(new Comando[]{encerderLuz1Cmd,encerderLuz2Cmd,encerderLuz3Cmd});
		MacroCmd macroOff=new MacroCmd(new Comando[]{apagarLuz1Cmd,apagarLuz2Cmd,apagarLuz3Cmd});	
		mando.setComando(1, macroOn, macroOff);
//		mando.setComando(2, encerderLuz3Cmd, apagarLuz3Cmd);

		//ahora usamos nuestro mando
		//mando.pulsarOn(0);
		mando.pulsarOn(1);
		mando.pulsarOff(1);

		

	}
}
