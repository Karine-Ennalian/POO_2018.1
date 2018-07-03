public class Servico {

	private String servicoId;
	private float valor;
	
	public Servico(String servicoId, float valor) {
		this.servicoId = servicoId;
		this.valor = valor;
	}

	public String getServicoId() {
		return servicoId;
	}

	public void setServicoId(String servicoId) {
		this.servicoId = servicoId;
	}

	public float getValor() {
		return valor;
	}

	public void setvalot(float valor) {
		this.valor = valor;
	}
	
	public String toString() {
		return "" + servicoId + ":" + valor;
	}
	
}