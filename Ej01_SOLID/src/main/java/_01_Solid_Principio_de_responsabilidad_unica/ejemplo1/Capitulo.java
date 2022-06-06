package _01_Solid_Principio_de_responsabilidad_unica.ejemplo1;

public class Capitulo {

	private Integer numero;
	private String titulo;
	private String texto;

	public Capitulo() {
		super();
	}

	public Capitulo(Integer numero, String titulo, String texto) {
		super();
		this.numero = numero;
		this.titulo = titulo;
		this.texto = texto;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void imprimirCapitulo_MAL() {
		System.out.println("Capítulo "+numero );
		System.out.println();
		System.out.println(titulo);
		System.out.println();
		System.out.println(texto);
		System.out.println();
	}

	public String imprimirCapitulo() {
		return new StringBuilder()
		 .append("Capítulo "+numero )
   		 .append("\n\n")
		 .append(titulo)
		 .append("\n\n")
		 .append(texto)
		 .append("\n\n")
		 .toString();
	}

}
