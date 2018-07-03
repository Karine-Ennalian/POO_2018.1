public class Agenda {

	private Repositorio<Entrada> entradas;
	private Repositorio<Entrada> favoritos;
	int quantidade = 0;
	public Agenda() {
		entradas = new Repositorio<Entrada>("entradas");
		favoritos = new Repositorio<Entrada>("favoritos");
	}

	public Repositorio<Entrada> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(Repositorio<Entrada> favoritos) {
		this.favoritos = favoritos;
	}

	public Repositorio<Entrada> getEntradas() {
		return entradas;
	}
	
	
	public void rmEntry(String identrada) {
		this.entradas.remove(identrada);
	}
	
	public String mostrarFavoritos() {
		String saida="";
		for(Entrada enter : favoritos.getAll())
			saida += enter.toString() + "\n";
		return saida;
	}
	
	public void favoritar(Entrada id) {
		if(!id.isIsfavorit())
			id.setIsfavorit(true);
		this.favoritos.add(id.getEntradaId(), id);
	}
	
	public void desfavoritar(Entrada id) {
		if(id.isIsfavorit())
			id.setIsfavorit(false);
		this.favoritos.remove(id.getEntradaId());
	}
	
	public String mostrar() {
		String saida="";
		for(Entrada enter : entradas.getAll()) {
			if(enter instanceof Senha) {
				quantidade = ((Senha) enter).getSenha().length();
				   saida += enter.toString() + " " + enter.converte(quantidade) + "\n";
			}
			else
			saida += enter.toString() + "\n";
		}
		
		
		return saida;
	}
}