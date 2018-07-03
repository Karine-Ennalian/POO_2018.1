public class Gerenciador {

	private Repositorio<Tweet> tweets;
	
	
	public Gerenciador() {
		tweets = new Repositorio<Tweet>("tweets");
	}

	public Repositorio<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(Repositorio<Tweet> tweets) {
		this.tweets = tweets;
	}
	
	public void gerarTweet(Tweet t) {
		this.tweets.add(" " + t.getTweetId(), t);
	}
	
	public String showTweets() {
		String saida = " ";
		for(Tweet t : tweets.getAll())
			saida += t.toString() + "\n";
		return saida;
	}
}
