public class Contato extends Entrada{

	private Repositorio<Telefone> fones;
	
	public Contato(String id) {
		super(id);
		fones = new Repositorio<Telefone>("telefones");
	}

	public Repositorio<Telefone> getFones() {
		return fones;
	}

	public void setFones(Repositorio<Telefone> fones) {
		this.fones = fones;
	}
	
	public void addFone(Telefone t) {
		this.fones.add(t.getFoneId(), t);
	}
	
	public void rmFone(String foneId) {
	    this.fones.remove(foneId);	
	}
	
	public String mostrarFone() {
		String saida = " [";
		for(Telefone t : fones.getAll())
			saida += t.toString() + "]" + "\n";
		return saida;
	}
	public String toString() {
		return super.toString() + fones.toString();
	}
}