public class Principal extends Agenda {

	private Agenda agenda;
	private Repositorio<Contato> contatos;
	private Repositorio<Mensagem> notas;
	private Repositorio<Senha> senhas;
	private String senhaMestra;
	
	
	public Principal(Agenda agenda) {
		this.agenda = agenda;
		this.senhaMestra = senhaMestra;
        contatos = new Repositorio<Contato>("contatos");
        notas = new Repositorio<Mensagem>("notas");
        senhas = new Repositorio<Senha>("senhas");
	}
	
	public Repositorio<Senha> getSenhas() {
		return senhas;
	}

	public void setSenhas(Repositorio<Senha> senhas) {
		this.senhas = senhas;
	}

	public String getSenhaMestra() {
		return senhaMestra;
	}

	public void setSenhaMestra(String senhaMestra) {
		this.senhaMestra = senhaMestra;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
	
	 public Repositorio<Contato> getContatos() {
			return contatos;
		}

		public Repositorio<Mensagem> getNotas() {
			return notas;
		}

	
	public void addNote() {
		for(Entrada e: agenda.getEntradas().getAll()) {
			if(e instanceof Mensagem)
		       this.notas.add(e.getEntradaId(),new Mensagem(e.getEntradaId(),((Mensagem) e).getTexto()));
		}
	}
		
	public void addContato() {
		for(Entrada e: agenda.getEntradas().getAll()) {
			if(e instanceof Contato)
		       this.contatos.add(e.getEntradaId(),new Contato(e.getEntradaId()));
		}
	}
	
	public void addPass() {
		for(Entrada e: agenda.getEntradas().getAll()) {
			if(e instanceof Senha)
		       this.senhas.add(e.getEntradaId(), new Senha(e.getEntradaId(),((Senha) e).getSenha()));
		}
    }
	
	public void mostrarSenhas(String senha) {
		if (senha.equals(senhaMestra)) {
			String saida = "";
			for (Senha s : this.senhas.getAll())
				saida += s.toString() + " " + s.getSenha() + "\n";
			System.out.println(saida);
		} else {
			String sai = "";
			for (Senha s : this.senhas.getAll()) {
				int quantidade = s.getEntradaId().length();
				sai += s.toString() + " " + s.converte(quantidade);
			}
			System.out.println(sai);
		}
	}
	
	public void mostrarSenhas() {
		String sai = "";
		for (Senha s : this.senhas.getAll()) {
			int quantidade = s.getEntradaId().length();
			sai += s.toString() + " " + s.converte(quantidade);
		}
		System.out.println(sai);
	}

}