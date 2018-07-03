public abstract class Entrada {

	private String entradaId;
	private boolean isfavorit ;
	
	public Entrada(String entradaId) {
		this.entradaId = entradaId;
		isfavorit = false;
	}

	public String getEntradaId() {
		return entradaId;
	}

	public void setEntradaId(String entradaId) {
		this.entradaId = entradaId;
	}

	public boolean isIsfavorit() {
		return isfavorit;
	}

	public void setIsfavorit(boolean isfavorit) {
		this.isfavorit = isfavorit;
	}
	
	public String converte(int qtd) {
		String saida="";
		for(int i=0; i<qtd; i++)
			saida += '*';
		return saida;
	}
	
	public String toString() {
		if(isfavorit)
		    return "@" + entradaId;
		else
			return "-" + entradaId;
	}
	
}