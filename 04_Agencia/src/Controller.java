import java.util.Scanner;

public class Controller {
		Repositorio<Cliente> usuarios;
		Repositorio<Conta> contas;
		Scanner scanner;
		Gerenciador gerenciador;
	     int num = 1;
	     int aux = 0;
		    
	public Controller() {
		scanner = new Scanner(System.in);
		usuarios = new Repositorio<Cliente>("username");
		gerenciador = new Gerenciador(usuarios);
		contas = new Repositorio<Conta>("conta");
	}

	public String query(String line) {
		String[] ui = line.split(" ");

		if (ui[0].equals("addCliente"))
			usuarios.add(ui[1], new Cliente(ui[1], ui[2]));
		else if (ui[0].equals("showUsers")) {
			String saida = "";
			for(Cliente us : usuarios.getAll())
				saida += us.getIdcliente() + "\n";
			return saida;
		}
		else if(ui[0].equals("loginCliente")) {
			gerenciador.Login(ui[1], ui[2]);
		    gerenciador.getUser().contas.add(""+ num , new Conta(num));
		    num++;
            aux++;
		}
		else if(ui[0].equals("depositar"))
		    gerenciador.getUser().contas.get(ui[1]).depositar(Float.parseFloat(ui[2]));	
		else if(ui[0].equals("sacar"))
			gerenciador.getUser().contas.get(ui[1]).sacar(Float.parseFloat(ui[2]));
		else if(ui[0].equals("encerrar")) {
			gerenciador.getUser().contas.get(ui[1]).encerrar();
			aux--;
		}
		else if(ui[0].equals("saldo"))
			System.out.println(""+gerenciador.getUser().contas.get(ui[1]).getSaldo());
		else if(ui[0].equals("addConta")) {
		if(aux > 1)
			throw new RuntimeException("fail: você possui o numero maximo de contas ativa");
		gerenciador.getUser().contas.add("" + num, new Conta(num));
		num++;
		aux++;
		}
		else if(ui[0].equals("transferir"))
			gerenciador.getUser().contas.get(ui[1]).transferir(Float.parseFloat(ui[2]), 
							usuarios.get(ui[3]).contas.get(ui[4]));
		    
		else if(ui[0].equals("logout"))
			gerenciador.Logout();
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
