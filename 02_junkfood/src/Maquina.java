import java.util.ArrayList;
import java.util.List;

public class Maquina {
	private List<Espiral> espirais;
	private float saldoCliente;
	private float lucro;

	public Maquina() {
		this.espirais = new ArrayList<>();
		this.saldoCliente = saldoCliente;
		this.lucro = lucro;
	}
	
	public List<Espiral> getEspirais() {
		return espirais;
	}
	public double getSaldoCliente() {
		return saldoCliente;
	}
	public void setSaldoCliente(float saldoCliente) {
		this.saldoCliente = saldoCliente;
	}
	public double getLucro() {
		return lucro;
	}
	public void setLucro(float lucro) {
		this.lucro = lucro;
	}
	
	public boolean addEspiral(Espiral espiral) throws Exception {
		for (Espiral esp : espirais) {
			if(esp.getNumEsp() == espiral.getNumEsp()) {
				throw new Exception("Espiral já existe");
			}
		}
		return this.espirais.add(espiral);
	}
	public boolean rmEspiral(int numEsp) throws Exception {
		for (Espiral espiral : espirais) {
			if(espiral.getNumEsp() == numEsp) {
				return this.espirais.remove(espiral);
			}
		}
		throw new Exception("Expiral não encontrado");
	}
	public boolean addProd(String nome, Produto produto) throws Exception {
		for (Espiral espiral : espirais) {
			if(espiral.getNomeProd().equals(nome)){
				return this.espirais.add(espiral);
			}
		}
		throw new Exception("Produto já existe");
	}
	public boolean rmProd(String nome, int cod) throws Exception {
		for (Espiral espiral : espirais) {
			if (espiral.getNomeProd().equals(nome)) {
				return espiral.rmProduto(cod);
			}
		}
		throw new Exception("Produto não encontrado");
	}
	public float inserirDinheiro(float valor) {
		if(valor > 0)
			this.saldoCliente += valor;
			return this.saldoCliente;
	}
	
	public float lucro() {
		if(this.saldoCliente > 0) 
			this.lucro += this.saldoCliente;
			return lucro;
	}
	
	public float troco(float valor) {
		if(valor > this.saldoCliente)
			valor -= this.saldoCliente;
			return valor;
	}
	
}
