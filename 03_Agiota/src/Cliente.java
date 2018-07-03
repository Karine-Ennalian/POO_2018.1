
public class Cliente {

	public String clienteId;
	public String nome;
	public String isAlive = "Alive";
	public float saldo = 0;
	
	public Cliente(String clienteId, String nome) {
		this.clienteId = clienteId;
		this.nome =  nome;
	}
	
	public String toString() {
		return " "+nome +":"+ clienteId+ ":" +isAlive + "\n";
	}
	
	public String mostrarSaldoClientes() {
		return " nome:" + nome +" saldo : " + saldo + "\n";
	}

	
}