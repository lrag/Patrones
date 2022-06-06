package _02_sOlid_Principio_de_abierto_cerrado_ejemplo1;

public class Mensaje {

	private String destinatario;
	private String texto;

	public Mensaje() {
		super();
	}

	public Mensaje(String destinatario, String texto) {
		super();
		this.destinatario = destinatario;
		this.texto = texto;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "Mensaje [destinatario=" + destinatario + ", texto=" + texto + "]";
	}

}
