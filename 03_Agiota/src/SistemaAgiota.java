import java.util.ArrayList;

public class SistemaAgiota {

		public float saldo = 0;
		public float dinheiro;
		public int idTransacao = 0;
		public int id = 0;
		
		ArrayList<Cliente> clientes;
		ArrayList<Divida> dividas;
		
		public SistemaAgiota(float dinheiro) {
			this.dinheiro = dinheiro;
			clientes = new ArrayList<Cliente>();
			dividas =  new ArrayList<Divida>();
			saldo = saldo + dinheiro;
		}


		public void cadastrarClientes(String nome, String clienteid) {
			for (Cliente c : clientes)
				if (c.nome.equals(nome))
					throw new RuntimeException("Cliente já cadastrado");

			clientes.add(new Cliente(clienteid, nome));
		}

		public void emprestarDinheiro(String nome, float valor) {
			for (Cliente c : clientes)
				if (c.nome.equals(nome) ) { 
					c.saldo = valor + c.saldo;
					this.cadastrarDivida(nome, valor);
		        }
			
			throw new RuntimeException("Cliente ou saldo invalido");
		}

		public void cadastrarDivida(String nome, float valor) {
		   if(valor <= saldo) {
			  saldo = saldo + valor;
		      this.dividas.add(new Divida(nome,valor, id));
		      id++;
		   }
		   else
			   throw new RuntimeException ("Saldo insuficiente");
		   
		}
		
		public String showDividas() {
				 return " " + dividas.toString();
		}

	    public String showClientes() {
	    	String saida =  " ";
	    	for(int i = 0; i < clientes.size(); i++)
	    	   saida += " "+ this.clientes.get(i).mostrarSaldoClientes();
	    	return saida;
	    }
	    
	    
		public void showClienteUnico(String nome) {
			int i = 0;
			for (Cliente c : clientes) {
				if (c.nome.equals(nome)) {
					System.out.println(c.mostrarSaldoClientes());
					while( dividas.get(i).nome.equals(nome)) {
						       System.out.println( dividas.get(i).toString());
			                   i++;       
					}
				}
			}
		    throw new RuntimeException("Cliente não encontrado");
		}

	 
		public void receberDinheiro(String nome, float valor) {
			for (Cliente c : clientes)
				if (c.nome.equals(nome)) {
					if (c.saldo < 0) {
						c.saldo = saldo + valor;
						dinheiro = dinheiro + valor;
						this.dividas.add(new Divida(nome, valor, id));
						id++;
					}
				}

			throw new RuntimeException("Cliente nao encontrado");

		}

		public void killCliente(String nome) {
			for( int i = 0; i < clientes.size(); i++) {
				if(clientes.get(i).nome.equals(nome)) {
					this.clientes.remove(clientes.get(i));
					apagarDividas(nome);
				}
			}
			throw new RuntimeException("Cliente não encontrado");
		}
		
		public void apagarDividas( String nome) {
			for(int i = 0 ; i<dividas.size(); i++) {
				if(dividas.get(i).nome.equals(nome))
					this.dividas.remove(dividas.get(i));
				i--;
			}
		}
			
		
	public String toString() {
		return "SistemaAgiota iniciado com : " + saldo + " " + clientes.toString() + "\n";
	}
}
