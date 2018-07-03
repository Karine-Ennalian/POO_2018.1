public class Sistema {

	private String descricao;
	private float valor;
	private float saldo = 0;
	
	public Sistema(String descricao, float valor) {
		this.descricao = descricao;
		this.valor = valor;
		this.saldo += valor;
	}
	
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public float getSaldoparcial() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public String toString() {
		return "" + descricao + " " + valor + " " + saldo;
	}
	
}
