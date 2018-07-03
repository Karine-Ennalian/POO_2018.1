
public class User {

	private String userId;
	private Repositorio<Chat> grups;
	private Repositorio<Mensagem> mensagens;
	int qttdMsg = 0;
	
	public User(String userId) {
		this.userId = userId;
		grups = new Repositorio<Chat>("grupos");
		mensagens = new Repositorio<Mensagem>("mensagens");
	}

	public Repositorio<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(Repositorio<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public Repositorio<Chat> getGrups() {
		return grups;
	}

	public void setGrups(Repositorio<Chat> grups) {
		this.grups = grups;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String toString() {
		return userId;
	}

	public Chat retornaChat(Chat c) {
		for(Chat chat : this.grups.getAll()) 
			if(chat.getChat().equals(c.getChat()))
				return c;
		
		throw new RuntimeException("fail: voce nao esta nesse grupo");
	}
	
	public void mostrarMensagens(Chat c) {
		if(this.retornaChat(c) != null) {
			System.out.println(c.mostrarSms(this.getUserId()));
		}	
	}
		
	public String contagem(Chat c) {
		String saida="";
		for(Mensagem m : c.getSms().getAll()) {
			if(!m.getUser().equals(this.userId)) {
				if(!m.isLido()) {
					qttdMsg++;
				   m.setLido(true);
				}
			}
		}
		saida += qttdMsg ;
		qttdMsg = 0;
		return saida;
	}
	public String mostrarGroups() {
		String saida ="[ ";
		for(Chat c : grups.getAll())
			saida+= c.toString() + " ";
		return saida + "]";
	}
}