package _01_Solid_Principio_de_responsabilidad_unica.ejemplo1;

import java.util.List;

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

	public String imprimir() {

		//StringBuffer es thread safe
		
		StringBuilder sb = new StringBuilder();
		sb.append(titulo);
		sb.append(autor+", "+year);
		sb.append("\n\n");
		sb.append(System.getProperty("line.separator"));
		capitulos.forEach(capitulo -> {
			sb.append(capitulo.imprimirCapitulo());
		});
		sb.append("FIN");
		return sb.toString();
	}

}
