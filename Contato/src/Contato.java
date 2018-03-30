import java.util.ArrayList;
import java.util.List;

public class Contato {
	private String nome;
	private List<Telefone> telefones;
	
	public Contato(String nome) {
		this.nome = nome;
		this.telefones = new ArrayList<>();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Telefone> getTelefones() {
		return telefones;
	}
	
	public boolean addTelefone(Telefone telefone) throws Exception {
		for (Telefone fone : telefones) {
			if(fone.foneId.equals(telefone.getFoneId())) {
				throw new Exception("Telefone já existe");
			}
		}
		return this.telefones.add(telefone);
	}
	
	public boolean rmTelefone(String foneId) throws Exception{
		for (Telefone fone : telefones) {
			if (fone.foneId.equals(foneId)) {
				return this.telefones.remove(fone);
			}
		}
		throw new Exception("Identificador não encontrado");
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.nome + " FoneId: " + this.telefones;
	}
}
