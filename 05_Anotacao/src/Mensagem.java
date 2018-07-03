
public class Mensagem {
	private String titulo;
	private String texto;
	
	public Mensagem(String titulo, String texto) {
		this.titulo = titulo;
		this.texto = texto;
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
	
	public String toString() {
		return titulo + ":" + texto;
	}
}
