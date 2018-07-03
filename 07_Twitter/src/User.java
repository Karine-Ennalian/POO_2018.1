public class User {

	private String userId;
	private Repositorio<User> seguidores;
	private Repositorio<User> seguidos;
	private Repositorio<Tweet> myTweets;
	private Repositorio<Tweet> timeline;
	Tweet mensagem;
	int contTwittes = 0;
	
	
	public User(String userId) {
		this.userId = userId;
		seguidores = new Repositorio<User>("seguidores");
		seguidos = new Repositorio<User>("seguidos");
		myTweets = new Repositorio<Tweet>("myTweets");
	    timeline = new Repositorio<Tweet>("timeline");
	}
	
	public Repositorio<Tweet> getTimeline() {
		return timeline;
	}
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Repositorio<User> getSeguidores() {
		return seguidores;
	}

	public Repositorio<User> getSeguidos() {
		return seguidos;
	}
	
	public String toString() {
		return " " + userId ;
	}
	
	public String showSeguidores() {
		String saida = "";
		for(User seg : seguidores.getAll())
			saida += seg + " ";
		return saida ;
	}
	
	public String showSeguidos() {
		String saida = "";
		for(User seg : seguidos.getAll())
			saida += seg + " ";
		return saida ;
	}

	public void seguir(User us) {
		
		us.seguidos.add(this.getUserId(), new User(this.getUserId()));
		this.seguidores.add(us.getUserId(), us);
	} 

    public void criarTweet(Tweet t) {
		this.myTweets.add(""+t.getTweetId(), t);
    }		
    
    public void addTime(Tweet t) {
    		this.timeline.add(""+t.getTweetId(), t);
    	
    }
    
	public String mostrarMytweets() {
    	String saida = "";  
    	for(Tweet s : myTweets.getAll()) {
    		saida += " " + s.getTweetId() + s.getUser() + ":"+s.getTitulo() + " " + s.getTexto() + "\n"; 
    	}
    	return saida;
    }
	
	public String mostrarTime() {
    	String saida = "";
    	for(Tweet s : timeline.getAll()) {
    		if(!s.isLido()) {
    		   saida += " " + s.getTweetId() + " " +s.getUser() + ":"+s.getTitulo() + " " + s.getTexto() + "\n"; 
    		   s.setLido(true);
    	       contTwittes++;
    	    }
    	}
    	System.out.println(" Voce tem :" + contTwittes + " tweets");
    	contTwittes = 0;
    	return saida;
    }
	
	public void darLike(int idtweet) {
		for(Tweet s : timeline.getAll()) {
			if(s.getTweetId() == idtweet){
				if(!s.isLike()) {
				   s.setLike(true);
				   return;
				}
			}
		}
		
		throw new RuntimeException("fail: você não possui esse tweet");
	}
	
	
}