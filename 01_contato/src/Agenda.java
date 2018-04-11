import java.util.ArrayList;
import java.util.List;

public class Agenda {
	private List<Contato> contatos;
	
	public Agenda() {
		this.contatos = new ArrayList<Contato>();
	}
	
	public List<Contato> getContatos() {
		return contatos;
	}
	
	public boolean addContato(Contato contato) throws Exception{
		for (Contato cont : contatos) {
			if(cont.getNome().equals(contato.getNome())) {
				throw new Exception("Contato já existente");
			}
		}
		return this.contatos.add(contato);
	}
	
	public boolean rmContato(String nome) throws Exception {
		for (Contato cont : contatos) {
			if(cont.getNome().equals(nome)) {
				return this.contatos.remove(cont);
			}
		}
		throw new Exception("Contato não existe");
	}
	
	public Contato seach(String nome) throws Exception {
		for (Contato contato : contatos) {
			if(contato.getNome().equals(nome)) {
				return contato;
			}
		}
		throw new Exception("Contato não encontrado");
	}
	
	public boolean addTelefone(String nome, Telefone telefone) throws Exception {
		for (Contato contato : contatos) {
			if(contato.getNome().equals(nome)) {
				return contato.addTelefone(telefone);
			}
		}
		throw new Exception("Contato não encontrado");
	}
	
	public boolean rmTelefone(String nome, String foneId) throws Exception {
		for (Contato contato : contatos) {
			if(contato.getNome().equals(nome)) {
				return contato.rmTelefone(foneId);
			}
		}
		throw new Exception("Contato não encontrado");
	}
	
	
}
