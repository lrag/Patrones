package curso.patrones.comando;

public class MandoProgramable {
	Comando[] comandosOn;
	Comando[] comandosOff;
	Comando comandoUndo;
	
	public MandoProgramable() {
		comandosOn=new Comando[7];
		comandosOff=new Comando[7];
		comandoUndo=new ComandoVacio();
		
		for (int i = 0; i < comandosOn.length; i++) {
			comandosOn[i]=new ComandoVacio();
			comandosOff[i]=new ComandoVacio();
		}
	}
	
	public void setComando(int pos, Comando cOn, Comando cOff){
		comandosOn[pos]=cOn;
		comandosOff[pos]=cOff;
	}
	
	public void pulsarOn(int pos){
		comandosOn[pos].ejecutar();
		comandoUndo=comandosOn[pos];
	}
	
	public void pulsarOff(int pos){
		comandosOff[pos].ejecutar();
		comandoUndo=comandosOff[pos];
	}
	
	public void pulsarUndo(){
		comandoUndo.deshacer();
	}
	
	@Override
	public String toString() {
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append("POS\t|ON\t\t\t|OFF\n");
		for (int i = 0; i < comandosOn.length; i++) {
			stringBuffer.append(i+"\t|"+comandosOn[i].getClass().getSimpleName()+
					"|"+comandosOn[i].getClass().getSimpleName()+"\n");
			
		}
		return stringBuffer.toString();
	}
}
