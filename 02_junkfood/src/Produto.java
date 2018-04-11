
public class Produto {
	public String nome;
	public int cod;
	public float preco;
	
	public Produto(String nome, int cod, float preco) {
		this.nome = nome;
		this.cod = cod;
		this.preco = preco;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", cod=" + cod + "]";
	}
	
}
