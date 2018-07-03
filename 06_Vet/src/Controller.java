import java.util.Scanner;

public class Controller {
		Repositorio<Dono> usuarios;
		Repositorio<Servico> servicos; 
		Repositorio<Venda> vendas;
		Scanner scanner;
		int num = 1;
		int totalVendas = 1;
		float saldo = 0; 
		
	public Controller() {
		scanner = new Scanner(System.in);
		usuarios = new Repositorio<Dono>("username");
		servicos = new 	Repositorio<Servico>("servicos");
		vendas = new Repositorio<Venda>("vendas");
	}

	public String query(String line) {
		String[] ui = line.split(" ");

		
		if (ui[0].equals("addCliente")) {
			 String texto = "";
	         for(int i = 2 ; i<ui.length; i++)
	    	     texto += ui[i] + " ";
			usuarios.add(ui[1], new Dono(ui[1], texto));
		}
		else if (ui[0].equals("showClientes")) {
			String saida = "";
			for(Dono d : usuarios.getAll())
				saida += d.toString() + "\n";
			return saida;
		}
		else if(ui[0].equals("addAnimal")) {
			usuarios.get(ui[1]).animais.add(ui[2] , new Animal(num,ui[2],ui[3], 
							new Dono(usuarios.get(ui[1]).getClienteId(), "")));
		    num++;
		}
		else if(ui[0].equals("showAnimal")) {
		   String saida = "";
		   for(Dono d : usuarios.getAll())
			   saida += d.mostrarAnimais() + "\n";
		   return saida;
		}
		else if(ui[0].equals("showAnimalCliente"))
		   System.out.println(usuarios.get(ui[1]).animais.getAll().toString());
		else if(ui[0].equals("addServico"))
			servicos.add(ui[1], new Servico(ui[1],Float.parseFloat(ui[2])));
		else if(ui[0].equals("showServicos")) {
			String saida = "";
			for(Servico s : servicos.getAll())
				saida += s.toString() + "\n";
			return saida;
		}
		else if(ui[0].equals("vender")) {
		    usuarios.get(ui[1]); 
		    usuarios.get(ui[1]).animais.get(ui[2]);
		    servicos.get(ui[3]);
		    vendas.add(""+totalVendas, new Venda(ui[1],ui[2],ui[3]));
		    saldo += servicos.get(ui[3]).getValor();
		    totalVendas++;
		}
		else if(ui[0].equals("showVendas")){
		    String saida = "";
		    for(Venda v : vendas.getAll())
			    saida += v.toString() + "\n";
		    return saida;
		}
		else if(ui[0].equals("showSaldo"))
			System.out.println(saldo);
		else
			return " Comando invalido";
		return "done";
	}




		public void shell() {
			while (true) {
				String line = scanner.nextLine();
				try {
					System.out.println(query(line));
				} catch (RuntimeException re) {
					System.out.println(re.getMessage());
				}
			}
		}
		
		public static void main(String[] args) {
	        Controller c = new Controller();
	        c.shell();
	    }
	  
	}