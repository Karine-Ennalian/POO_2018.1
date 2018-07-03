public class Dono {

	private String clienteId;
	private String nome;
	Repositorio<Animal> animais;
	public Dono(String clienteId, String nome) {
		this.clienteId = clienteId;
		this.nome = nome;
		animais = new Repositorio<Animal>("animais");
	}

	public String getClienteId() {
		return clienteId;
	}

	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	public Repositorio<Animal> getAnimais() {
		return animais;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String mostrarAnimais() {
		String saida = "";
		for(Animal a : animais.getAll())
			saida += a.toString() + "\n";
		return saida;
	}
	
	public String toString() {
		return "" + clienteId + " : " + nome;
	}
}
