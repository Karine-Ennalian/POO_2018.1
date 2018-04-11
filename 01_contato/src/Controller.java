import java.util.ArrayList;

public class Controller {
	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		
		while (true) {
			String line = Input.input("Digite um comando: ");
			System.out.println(line);
			ArrayList<String> userInput = Input.split(line, " ");
			
			try {
				if(userInput.get(0).equals("addContato")) {
					agenda.addContato(new Contato(userInput.get(1)));
				}else if (userInput.get(0).equals("rmContato")) {
					agenda.rmContato(userInput.get(1));
				}else if (userInput.get(0).equals("seach")) {
					agenda.seach(userInput.get(1));
				}else if (userInput.get(0).equals("addFone")) {
					agenda.addTelefone(userInput.get(1), new Telefone(userInput.get(2), 
														Input.toInt(userInput.get(3))));
				}else if (userInput.get(0).equals("rmFone")) {
					agenda.rmTelefone(userInput.get(1), userInput.get(2));
				}else if (userInput.get(0).equals("fim")) {
					break;
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
