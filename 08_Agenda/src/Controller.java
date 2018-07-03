import java.util.Scanner;

public class Controller {

		Scanner sca;
        Agenda agenda;
        Principal master;
		
	public Controller() {
		sca = new Scanner(System.in);
		agenda = new Agenda();
		master = new Principal(agenda);
	}

	public String query(String line) {
		String[] ui = line.split(" ");

		if (ui[0].equals("addContato"))
			agenda.getEntradas().add(ui[1], new Contato(ui[1]));
		else if(ui[0].equals("addPass")) 
			agenda.getEntradas().add(ui[1], new Senha(ui[1],ui[2]));
		else if (ui[0].equals("addNota")) {
			String texto = "";
			for (int i = 2; i < ui.length; i++)
				texto += ui[i] + "";
			agenda.getEntradas().add(ui[1], new Mensagem(ui[1], texto));
		} 
		else if(ui[0].equals("masterPass"))
			master.setSenhaMestra(ui[1]);
		else if(ui[0].equals("showPassmestre"))
			master.mostrarSenhas(ui[1]);
		else if(ui[0].equals("showPass")) {
			master.addPass();
			String saida = "";
			for (Senha s : master.getSenhas().getAll()) {
				int quantidade = s.getEntradaId().length();
				saida += s.toString() + " " + s.converte(quantidade) + "\n";
			}
			return saida;
		}
		else if (ui[0].equals("showFones")) {
			System.out.println("User: " + master.getContatos().get(ui[1]).getEntradaId());
			System.out.println(master.getContatos().get(ui[1]).mostrarFone());
		} 
		else if (ui[0].equals("addFone"))
			master.getContatos().get(ui[1]).addFone(new Telefone(ui[2], ui[3]));
		else if (ui[0].equals("rmFone")) 
			master.getContatos().get(ui[1]).rmFone(ui[2]);
		else if (ui[0].equals("showContatos")) {
			master.addContato();
			String saida = "";
			for (Contato c : master.getContatos().getAll())
				saida += c.toString() + "\n";
			return saida;
		} 
		else if (ui[0].equals("showNotas")) {
			master.addNote();
			String saida = "";
			for (Mensagem n : master.getNotas().getAll())
				saida += n.toString() + "\n";
			return saida;
		} 
		else if (ui[0].equals("fav"))
			agenda.favoritar(agenda.getEntradas().get(ui[1]));
		else if (ui[0].equals("desfav"))
			agenda.desfavoritar(agenda.getEntradas().get(ui[1]));
		else if (ui[0].equals("mostrarfavoritos")) 
			System.out.println(agenda.mostrarFavoritos());
		else if (ui[0].equals("showEntradas")) 
			System.out.println(agenda.mostrar());
		else
			return " Comando invalido";
		return "done";
	}

		public void shell() {
			while (true) {
				String line = sca.nextLine();
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