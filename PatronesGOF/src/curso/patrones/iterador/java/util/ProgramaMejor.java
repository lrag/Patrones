package curso.patrones.iterador.java.util;

import java.util.Arrays;
import java.util.List;

public class ProgramaMejor {
	public static void main(String[] args) {
		MenuDesayunos desayunos=new MenuDesayunos();
		desayunos.añadir(new ItemMenu("desayuno normal","café y bollo",2,true));
		desayunos.añadir(new ItemMenu("desayuno super","café, zumo, huevos y bacon",4,false));
		desayunos.añadir(new ItemMenu("pulguita","caña y pulga",2.50,false));
		
		MenuCenas cenas=new MenuCenas();
		cenas.añadir(new ItemMenu("ensalada mixta","tomate, lechuga y atun",5,true));
		cenas.añadir(new ItemMenu("perrito","hot dog con patatas",3,false));
		cenas.añadir(new ItemMenu("ensalada pasta","pasta, y salsa rosa",4.50,true));
		cenas.añadir(new ItemMenu("PIZZA","distintos sabores",2,true));
		
		MenuBebidas bebidas=new MenuBebidas();
		bebidas.añadir(new ItemMenu("orujo","de hievas",1,true));
		bebidas.añadir(new ItemMenu("pacharan","de endrinas",1.20,true));
		bebidas.añadir(new ItemMenu("coñac","magno",1.50,true));
		
		List menus=Arrays.asList(desayunos,bebidas,cenas);
		
		CartaMejor carta=new CartaMejor(menus);
		carta.imprimir();
		
	}
}
