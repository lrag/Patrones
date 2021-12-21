package curso.patrones.iterador;

public class Programa {
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
		
		Carta carta=new Carta(desayunos,cenas);
		carta.imprimir();
		
	}
}
