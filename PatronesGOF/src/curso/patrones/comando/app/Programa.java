package curso.patrones.comando.app;

import curso.patrones.comando.*;

public class Programa {
	public static void main(String[] args) {
		Luz luz=new Luz("cocina");
		TV tv=new TV();
		Puerta puerta=new Puerta("garage");
		
		EncerderLuzCmd encerderLuzCmd=new EncerderLuzCmd(luz);
		ApagarLuzCmd apagarLuzCmd=new ApagarLuzCmd(luz);
		EncerderTVCmd encerderTVCmd =new EncerderTVCmd(tv);
		ApagarTVCmd apagarTVCmd =new ApagarTVCmd(tv);
		AbrirPuertaCmd abrirPuertaCmd=new AbrirPuertaCmd(puerta);
		CerrarPuertaCmd cerrarPuertaCmd=new CerrarPuertaCmd(puerta);
		CadenaHIFI cadenaHIFI=new CadenaHIFI();
		MandoProgramable mando=new MandoProgramable();
		mando.setComando(0, encerderLuzCmd, apagarLuzCmd);
		mando.setComando(1, encerderTVCmd, apagarTVCmd);
		mando.setComando(2, abrirPuertaCmd, cerrarPuertaCmd);
		mando.setComando(3, new PonerVolumenBajoCmd(cadenaHIFI), new ComandoVacio());
		mando.setComando(4,  new PonerVolumenMedioCmd(cadenaHIFI), new ComandoVacio());
		mando.setComando(5,  new PonerVolumenAltoCmd(cadenaHIFI), new ComandoVacio());
		mando.setComando(6,  new PonerVolumenMuyAltoCmd(cadenaHIFI), new ComandoVacio());
		//ahora usamos nuestro mando
//		mando.pulsarOn(0);
//		mando.pulsarOn(1);
//		mando.pulsarOn(2);
//		mando.pulsarUndo();
//		mando.pulsarOff(2);
//		mando.pulsarOff(1);
//		mando.pulsarOff(0);
		
		mando.pulsarOn(3);
		mando.pulsarOn(6);
		mando.pulsarUndo();
		

	}
}
