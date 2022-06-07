package _01_Solid_Principio_de_responsabilidad_unica.ejemplo1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//@Entity
public class Libro {

	private String titulo;
	private String autor;
	private Integer year;
	private List<Capitulo> capitulos;

	public Libro() {
		super();
	}

	public Libro(String titulo, String autor, Integer year, List<Capitulo> capitulos) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.year = year;
		this.capitulos = capitulos;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public List<Capitulo> getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}

	//Esto hace tres cosas
	//Sabe imprimir el libro
	//Sabe imprimir el capítulo
	public void imprimir_MAL() {
		System.out.println(titulo);
		System.out.println(autor+", "+year);
		System.out.println();
		capitulos.forEach(capitulo -> {
			System.out.println("Capítulo " + capitulo.getNumero());
			System.out.println();
			System.out.println(capitulo.getTitulo());
			System.out.println();
			System.out.println(capitulo.getTexto());
			System.out.println();
		});
		System.out.println("FIN");
	}

	//Un poco mejor, delega en el capítulo la responsabilidad de imprimirlo
	public void imprimir_MAL_2() {
		System.out.println(titulo);
		System.out.println(autor+", "+year);
		System.out.println();
		capitulos.forEach(capitulo -> {
			capitulo.imprimir_MAL();
		});
		System.out.println("FIN");
	}
	
	public String formatearTexto() {

		//StringBuffer es thread safe

		//StringBuilder no es thread safe pero en esta situación 
		//no supone ningun problema
		StringBuilder sb = new StringBuilder();
		sb.append(titulo);
		sb.append(autor+", "+year);
		sb.append("\n\n");
		capitulos.forEach(capitulo -> {
			sb.append(capitulo.imprimir());
		});
		sb.append("FIN");
		return sb.toString();		
	}
	
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public String formatearFecha(Date fecha) {
		return sdf.format(fecha);
	}
	
	

}


