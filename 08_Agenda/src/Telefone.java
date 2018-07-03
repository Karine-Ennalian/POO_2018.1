
public class Telefone {

	private String foneId;
	private String number;
	
	public Telefone(String foneId, String number) {
		this.foneId = foneId;
		this.number = number;
	}

	public String getFoneId() {
		return foneId;
	}

	public void setFoneId(String foneId) {
		this.foneId = foneId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public String toString() {
		return  foneId + ":" + number;
	}
}
