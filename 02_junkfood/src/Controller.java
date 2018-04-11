import java.util.ArrayList;

public class Controller {
public static void main(String[] args) {
	Maquina maquina = new Maquina();
	
	while (true) {
		String line = Input.input("Digite um comando: ");
		System.out.println(line);
		ArrayList<String> userInput = Input.split(line, " ");
		
		try {
			if(userInput.get(0).equals("addEspiral")) {
				maquina.addEspiral(new Espiral(Integer.parseInt(userInput.get(2)), userInput.get(1)));
			}else if(userInput.get(0).equals("rmEspiral")) {
				maquina.rmEspiral(Integer.parseInt(userInput.get(1)));
			}else if(userInput.get(0).equals("addProd")) {
				maquina.addProd(userInput.get(1), new Produto(userInput.get(2), 
			     								  Integer.parseInt(userInput.get(3)), 
												  Float.parseFloat(userInput.get(4))));
			}else if(userInput.get(0).equals("rmProd")) {
				maquina.rmProd(userInput.get(1), Integer.parseInt(userInput.get(2)));
			}else if(userInput.get(0).equals("inserirDinheiro")) {
				maquina.inserirDinheiro(Float.parseFloat(userInput.get(1)));
			}else if(userInput.get(0).equals("troco")) {
				maquina.troco(Float.parseFloat(userInput.get(1)));
			}
			else if (userInput.get(0).equals("fim")) {
				break;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
}
