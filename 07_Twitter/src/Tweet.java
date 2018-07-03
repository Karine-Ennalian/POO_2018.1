import java.util.ArrayList;

public class Tweet {

	private int tweetId;
	User user;
	private String titulo;
	private String texto;
	private boolean isLike;
	private boolean isLido;
	private ArrayList<String> qtddlikes ;
	
	public Tweet(int tweetId, User user, String titulo, String texto) {
		this.tweetId = tweetId;
		this.user = user;
		this.titulo = titulo;
		this.texto = texto;
		this.isLido = false;
		this.isLike = false;
		qtddlikes = new ArrayList<String>();
	}
	

	public int getTweetId() {
		return tweetId;
	}

	public void setTweetId(int tweetId) {
		this.tweetId = tweetId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
	
	public boolean isLike() {
		return isLike;
	}


	public void setLike(boolean isLike) {
		this.isLike = isLike;
	}


	public boolean isLido() {
		return isLido;
	}


	public void setLido(boolean isLido) {
		this.isLido = isLido;
	}
	
	public ArrayList<String> getQtddlikes() {
		return qtddlikes;
	}
	
	public void darLike(String username) {
       this.qtddlikes.add(username);
	}
	
	
	public String showLikes() {
		String saida = "";
		for(int i = 0; i < qtddlikes.size(); i++) {
			saida += ":" + qtddlikes.get(i) + "\n";
		}
		return saida;
	}
	
	public String toString() {
		return ""+ tweetId + ": "+ user + ": " + titulo + ": " + texto ;
	}
}