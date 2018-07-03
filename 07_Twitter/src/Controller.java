import java.util.Scanner;

public class Controller {
		Repositorio<User> usuarios;
		Scanner scanner;
		int totalTweet= 1;
		Gerenciador gerenciador;
		int contTweets = 0;
		
	public Controller() {
		scanner = new Scanner(System.in);
		usuarios = new Repositorio<User>("username");
		gerenciador = new Gerenciador();
	}

	public String query(String line) {
		String[] ui = line.split(" ");

		
		if (ui[0].equals("addUser")) 
			 usuarios.add(ui[1], new User(ui[1]));
		
		else if(ui[0].equals("showUser")) {
			String saida= "";
			for(User user : usuarios.getAll())
				saida += user.toString() + " seguidores: ["+ user.showSeguidores() +
										"] seguidos: [" + user.showSeguidos() +"] \n";
		    return saida;
		}	
		
		else if(ui[0].equals("seguir")) 
			usuarios.get(ui[2]).seguir(usuarios.get(ui[1]));
		
		else if(ui[0].equals("criartweet")) {
	       String texto = "";
	       for(int i = 3 ; i<ui.length; i++)
	    	   texto += ui[i] + " ";
	       
	       for(User s : usuarios.get(ui[1]).getSeguidores().getAll()) 
        	   s.addTime(new Tweet(totalTweet, usuarios.get(ui[1]), ui[2], texto));
           
           usuarios.get(ui[1]).criarTweet(new Tweet(totalTweet, usuarios.get(ui[1]), ui[2], texto));      
           gerenciador.gerarTweet(new Tweet(totalTweet, usuarios.get(ui[1]), ui[2],texto));  
           totalTweet++;
		}
		
		else if(ui[0].equals("mostrarMytweets"))
			System.out.println(usuarios.get(ui[1]).mostrarMytweets());
		
		else if(ui[0].equals("mostrartweets"))
			System.out.println(gerenciador.showTweets());
		
		else if(ui[0].equals("mostrarTime")) 
			System.out.println(usuarios.get(ui[1]).mostrarTime());
		
		else if(ui[0].equals("liketweet")) {
			usuarios.get(ui[1]).darLike(Integer.parseInt(ui[2]));
			gerenciador.getTweets().get(ui[2]).darLike(usuarios.get(ui[1]).getUserId());
		}
		
		else if(ui[0].equals("showlikes")) {
			System.out.println(" " + gerenciador.getTweets().get(ui[1]).showLikes());
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
				} catch (RuntimeException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
		public static void main(String[] args) {
	        Controller c = new Controller();
	        c.shell();
	    }
	  
	}