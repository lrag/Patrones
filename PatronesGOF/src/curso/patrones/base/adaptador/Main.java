package curso.patrones.base.adaptador;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Ave> pajaros = new ArrayList<>();
		pajaros.add(new Gallina());
		pajaros.add(new Pato());
		//pajaros.add(new Pterodactilo());
		pajaros.add(new DinosaurioAveAdaptador(new Pterodactilo()));
		
	}
	
}
