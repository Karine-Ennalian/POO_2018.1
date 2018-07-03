public class Venda {

	private String clienteId;
	private String animalId;
	private String servicoId;
	
	public Venda(String clienteId, String animalId, String servicoId) {
		this.clienteId = clienteId;
		this.animalId = animalId;
		this.servicoId = servicoId;
	}

	public String getClienteId() {
		return clienteId;
	}

	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	public String getAnimalId() {
		return animalId;
	}

	public void setAnimalId(String animalId) {
		this.animalId = animalId;
	}

	public String getservicoId() {
		return servicoId;
	}

	public void setServicoId(String servicoId) {
		this.servicoId = servicoId;
	}
	
	public String toString() {
		return "" + clienteId + ":" + animalId + ":" + servicoId;
	}
	
}