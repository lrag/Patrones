package curso.patrones.base.adaptador.problema;


import java.util.ArrayList;
import java.util.List;

import curso.patrones.base.adaptador.Ave;
import curso.patrones.base.adaptador.Gallina;
import curso.patrones.base.adaptador.Pterodactilo;


public class Programa2 {
	public static void main(String[] args) {
		List aves=new ArrayList();
		Gallina gallina=new Gallina();
		Pterodactilo pterodactilo=new Pterodactilo();
		
		aves.add(gallina);
		aves.add(pterodactilo);
		
		for(Object obj:aves){
			Ave ave=(Ave) obj;		
			ave.cantar();
			ave.nadar();
			ave.volar();
		}
		
	}
}
