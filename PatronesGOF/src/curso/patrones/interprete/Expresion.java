package curso.patrones.interprete;

public abstract class Expresion {
	public abstract String uno();
	public abstract String cuatro();
	public abstract String cinco();
	public abstract String nueve();
	public abstract int multiplicador();
	
	public void interpretar(Contexto contexto){
		if(contexto.entrada.startsWith(nueve())){
			contexto.salida += (9 * multiplicador());
			contexto.entrada = contexto.entrada.substring(2);
		}else if(contexto.entrada.startsWith(cuatro())){
			contexto.salida += (4 * multiplicador());
			contexto.entrada = contexto.entrada.substring(2);
		}else if(contexto.entrada.startsWith(cinco())){
			contexto.salida += (5 * multiplicador());
			contexto.entrada = contexto.entrada.substring(1);
		}
		while (contexto.entrada.startsWith(uno())){
			contexto.salida += (1 * multiplicador());
			contexto.entrada = contexto.entrada.substring(1);
		}
	}
	
	
}
