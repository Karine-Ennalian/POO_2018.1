
public class Divida {
	public String nome;
	public float valorDivida;
	public int id = 0;
	public float total = 0;
	
	public Divida(String nome, float valor, int id) {
		this.nome = nome;
		this.valorDivida = valor;
		this.id = id;
		this.total = valorDivida + total;
	}
	
	public String toString() {
		return  " id:" + id + " nome:" + nome + " valor:" + valorDivida +"\n";
	}
}
