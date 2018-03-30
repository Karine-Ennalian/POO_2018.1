
public class Telefone {
	public String foneId;
	public int numero;
	
	public Telefone(String foneId, int numero) {
		this.foneId = foneId;
		this.numero = numero;
	}
	
	public String getFoneId() {
		return this.foneId;
	}
	
	public void setFoneId(String foneId) {
		this.foneId = foneId;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	@Override
	public String toString() {
		return "FoneId: " + this.foneId + " Numero: " + this.numero;
	}
}
