package _01_Solid_Principio_de_responsabilidad_unica.ejemplo1;

import java.util.Arrays;
import java.util.List;

public class Aplicacion {

	public static void main(String[] args) {
		
		Capitulo c1 = new Capitulo(1,"Contra la estupidez...","Lorem fistrum tiene musho peligro qu� dise usteer ese pedazo de hasta luego Lucas sexuarl por la gloria de mi madre \nhasta luego Lucas jarl a gramenawer. Est� la cosa muy malar al ataquerl me cago en tus muelas \ntiene musho peligro ahorarr apetecan a wan. La caidita benemeritaar va ust� muy cargadoo no  \npuedor de la pradera por la gloria de mi madre pupita ese pedazo de. Ese pedazo de diodeno a peich  \nmamaar te voy a borrar el cerito pupita sexuarl mamaar. Al ataquerl a wan jarl por la gloria de mi  \nmadre me cago en tus muelas. Caballo blanco caballo negroorl mamaar diodeno quietooor benemeritaar no  \npuedor ese que llega jarl ahorarr hasta luego Lucas. Apetecan va ust� muy cargadoo quietooor  \nhasta luego Lucas no puedor. La caidita papaar papaar condemor la caidita ese que llega no puedor  \nest� la cosa muy malar mamaar pupita por la gloria de mi madre.");
		Capitulo c2 = new Capitulo(2,"...Los propios dioses...","Lorem fistrum qu� dise usteer pecador va ust� muy cargadoo tiene musho peligro va ust� muy cargadoo no te digo trigo \npor no llamarte Rodrigor ahorarr condemor por la gloria de mi madre me cago en tus muelas. \nAmatomaa torpedo torpedo ese que llega no puedor de la pradera papaar papaar a gramenawer fistro  \ntiene musho peligro sexuarl. Te va a has� pupitaa ahorarr ese que llega pupita caballo blanco caballo  \nnegroorl de la pradera qu� dise usteer. Fistro diodeno ese que llega diodeno no puedor te va a  \nhas� pupitaa a wan jarl la caidita a wan est� la cosa muy malar. A wan qu� dise usteer benemeritaar qu�  \ndise usteer condemor pupita te voy a borrar el cerito qu� dise usteer tiene musho peligro.  \nLlevame al sircoo a gramenawer a wan me cago en tus muelas papaar papaar ese pedazo de condemor la caidita.");
		Capitulo c3 = new Capitulo(3,"...�Luchan en vano?","Lorem fistrum la caidita condemor diodenoo no puedor ese pedazo de. De la pradera la caidita ese pedazo de mamaar qu� \ndise usteer al ataquerl. Amatomaa no te digo trigo por no llamarte Rodrigor qu� dise usteer \ndiodeno hasta luego Lucas a gramenawer sexuarl ese pedazo de por la gloria de mi madre. Amatomaa  \npecador te voy a borrar el cerito de la pradera apetecan condemor ese hombree quietooor qu� dise  \nusteer la caidita sexuarl. Benemeritaar va ust� muy cargadoo condemor la caidita quietooor diodenoo.  \nDe la pradera ese que llega va ust� muy cargadoo pupita caballo blanco caballo negroorl ese que llega  \nest� la cosa muy malar a gramenawer qu� dise usteer amatomaa.");
		List<Capitulo> capitulos = Arrays.asList(c1,c2,c3);
		
		Libro libro = new Libro("Los propios Dioses", "Isaac Asimov", 1972, capitulos);
		
		//libro.imprimir_MAL();
		//libro.imprimir_MAL_2();
		
		System.out.println(libro.formatearTexto());
	}
	
}
