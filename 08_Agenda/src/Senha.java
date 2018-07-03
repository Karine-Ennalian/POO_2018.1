public class Senha extends Entrada{

    private String senha;
	
	public Senha(String id, String senha) {
		super(id);
		this.senha = senha;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String toString() {
		return "" + super.toString();
	}
}