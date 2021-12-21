package curso.patrones.composicion;

import java.util.Arrays;
import java.util.List;

public class ProgramaMejor {
	public static void main(String[] args) {
		
		MenuComponente raiz=new MenuRama("carta del restaurante");
		
		
		MenuComponente desayunos=new MenuRama("desayunos");
		desayunos.añadir(new ItemMenu("desayuno normal","café y bollo",2,true));
		desayunos.añadir(new ItemMenu("desayuno super","café, zumo, huevos y bacon",4,false));
		desayunos.añadir(new ItemMenu("pulguita","caña y pulga",2.50,false));
		
		MenuComponente cenas=new MenuRama("cenas");
		cenas.añadir(new ItemMenu("ensalada mixta","tomate, lechuga y atun",5,true));
		cenas.añadir(new ItemMenu("perrito","hot dog con patatas",3,false));
		cenas.añadir(new ItemMenu("ensalada pasta","pasta, y salsa rosa",4.50,true));
		cenas.añadir(new ItemMenu("PIZZA","distintos sabores",2,true));
		
		MenuComponente bebidas=new MenuRama("bebidas");
		bebidas.añadir(new ItemMenu("orujo","de hierbas",1,true));
		bebidas.añadir(new ItemMenu("pacharan","de endrinas",1.20,true));
		bebidas.añadir(new ItemMenu("coñac","magno",1.50,true));
		
		desayunos.añadir(bebidas);
		cenas.añadir(bebidas);
		
		raiz.añadir(desayunos);
		raiz.añadir(cenas);
		
		raiz.imprimir();
		
	}
}
