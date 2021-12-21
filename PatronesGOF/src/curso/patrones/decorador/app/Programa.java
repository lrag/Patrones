package curso.patrones.decorador.app;

import curso.patrones.decorador.Bebida;
import curso.patrones.decorador.Cafe;
import curso.patrones.decorador.ChocolateDecorator;
import curso.patrones.decorador.LecheDecorator;
import curso.patrones.decorador.LimonDecorator;
import curso.patrones.decorador.Te;

public class Programa {
	public static void main(String[] args) {
		Bebida bebida=new Cafe();
		bebida=new LecheDecorator(bebida);
		bebida=new ChocolateDecorator(bebida);
		bebida=new ChocolateDecorator(bebida);
		System.out.println(bebida.getDescripcion()+"-->"+bebida.calcularPrecio());
		
		Bebida te=new Te();
		te=new AguaAzaharDecorator(new LimonDecorator(te));
		System.out.println(te.getDescripcion()+"-->"+te.calcularPrecio());
		
	}
}
