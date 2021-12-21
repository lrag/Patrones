package curso.patrones.base.adaptador;


import java.util.ArrayList;
import java.util.List;




public class Programa {
	public static void main(String[] args) {
		List aves=new ArrayList();
		Gallina gallina=new Gallina();
		Pterodactilo pterodactilo=new Pterodactilo();
		DinosaurioAveAdaptador adaptador=new DinosaurioAveAdaptador(pterodactilo);
		
		aves.add(gallina);
		aves.add(adaptador);
		
		//Pterodactilo no es un ave y puede serlo nunca porque ya es un dinosaurio
		// cualquier cambio en ave/dinosaurio/Pterodactilo esta PROHIBIDO
		for(Object obj:aves){
			Ave ave=(Ave) obj;		
			ave.cantar();
			ave.nadar();
			ave.volar();
		}
		
	}
}
