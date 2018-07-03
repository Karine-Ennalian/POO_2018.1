public class Cliente implements Comparable<Cliente> {

	private String clienteId;
	private String password;
	Repositorio<Conta> contas;
	static int numero = 1;
	
	public Cliente(String clienteId, String password) {
		this.clienteId = clienteId;
		this.password = password;
		this.contas = new Repositorio<Conta>("contas");
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}
	
	public String getIdcliente() {
		return clienteId;
	}

	public void setIdcliente(String clienteId) {
		this.clienteId = clienteId;
	}

	public Repositorio<Conta> getContas() {
		return contas;
	}


	public void addConta() {
		this.contas.add("numero" ,new Conta(numero));
	}
	
	public int compareTo(Cliente other) {
		
		return this.clienteId.compareTo(other.clienteId);
	}
	
	public String toString() {
		return " Cliente:" + clienteId;
	}
}