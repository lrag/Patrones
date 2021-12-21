package curso.patrones.interprete;

import java.util.ArrayList;
import java.util.List;

public class programa {
public static void main(String[] args) {
	String romano = "XXV";
	Contexto contexto = new Contexto(romano);
	List<Expresion> lista = new ArrayList<Expresion>();
	lista.add(new MilExpresion());
	lista.add(new CienExpresion());
	lista.add(new DiezExpresion());
	lista.add(new UnoExpresion());
	
	for (Expresion expresion : lista) {
		expresion.interpretar(contexto);
	}
	System.out.println(contexto.salida);
}
}
