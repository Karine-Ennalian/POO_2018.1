import java.util.Scanner;

public class Controller {
		Repositorio<User> usuarios;
		Repositorio<Mensagem> msg;
		Scanner scanner;
		Gerenciador gerenciador;
		    
		    
	public Controller() {
		scanner = new Scanner(System.in);
		usuarios = new Repositorio<User>("username");
		gerenciador = new Gerenciador(usuarios);
		msg = new Repositorio<Mensagem>("mensagens");
	}

	public String query(String line) {
		String[] ui = line.split(" ");

		if (ui[0].equals("addUser"))
			usuarios.add(ui[1], new User(ui[1], ui[2]));
		else if (ui[0].equals("showUsers")) {
			String saida = "";
			for(User us : usuarios.getAll())
				saida += us.getUsername() + "\n";
			return saida;
		}
		else if(ui[0].equals("loginUser"))
			gerenciador.Login(ui[1], ui[2]);
		else if(ui[0].equals("logoutUser"))
			gerenciador.Logout();
		else if(ui[0].equals("addPassword")){
			if(gerenciador.getUser().matchPassword(ui[1]))
				gerenciador.getUser().setPassword(ui[2]);
		}
		else if(ui[0].equals("adsMensagem")) {
		    String texto = "";
		    for(int i = 2 ; i<ui.length; i++)
		    	texto += ui[i] + "";
		    gerenciador.getUser().notas.add(ui[1], new Mensagem(ui[1],texto)); 	
		}
		else if(ui[0].equals("rmMensagem"))
			gerenciador.getUser().notas.remove(ui[1]);
		else if(ui[0].equals("showMensagens")) {
			String saida ="";
		for(User u : usuarios.getAll())
			saida += u.getMensagens() + "\n";
		return saida;
		}
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

