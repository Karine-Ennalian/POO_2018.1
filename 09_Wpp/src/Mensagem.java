public class Mensagem {

	private String indice ;
	private String user;
	private String texto;
	private boolean isLido;
	
	public Mensagem(String indice, String user, String texto) {
		this.indice = indice;
		this.user = user;
		this.texto = texto;
		this.isLido = false;
	}

	public boolean isLido() {
		return isLido;
	}

	public void setLido(boolean isLido) {
		this.isLido = isLido;
	}


	public String getIndice() {
		return indice;
	}

	public void setIndice(String indice) {
		this.indice = indice;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String toString() {
		return " " + user + ": " + texto;
	}
}
