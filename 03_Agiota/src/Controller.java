import java.util.Scanner;

public class Controller {
	SistemaAgiota sistemaAgiota;
	Scanner scanner;
	    
	    
	public Controller() {
		scanner = new Scanner(System.in);
		
	}

	public String query(String line) {
		String[] ui = line.split(" ");
		
	    if (ui[0].equals("init"))
			sistemaAgiota = new SistemaAgiota(Float.parseFloat(ui[1]));
	    else if (ui[0].equals("show"))
			return " " + sistemaAgiota ;
	    else if(ui[0].equals("cadastrarCliente"))
	    	sistemaAgiota.cadastrarClientes(ui[1],ui[2]);
	    else if(ui[0].equals("showDividas"))
	    	return "" + sistemaAgiota.showDividas() ;
	    else if(ui[0].equals("emprestarDinheiro"))
	    	sistemaAgiota.emprestarDinheiro(ui[1],Float.parseFloat(ui[2]));
	    else if(ui[0].equals("showClientes"))
	    	return ""+ sistemaAgiota.showClientes();
	    else if(ui[0].equals("showClienteUnico"))
	        sistemaAgiota.showClienteUnico(ui[1]);
	    else if(ui[0].equals("receberDinheiro"))
	    	sistemaAgiota.receberDinheiro(ui[1],Float.parseFloat(ui[2]));
	    else if(ui[0].equals("killCliente"))
	    	sistemaAgiota.killCliente(ui[1]);
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