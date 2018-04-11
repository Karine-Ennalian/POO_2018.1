import java.util.ArrayList;
import java.util.List;

public class Espiral {
	public static int quantMax;
	public static int numEsp;
	public List<Produto> produtos;
	public String nomeProd;
	//public double preco;
	
	public Espiral(int quantMax, String nomeProd/*, double preco*/) {
		Espiral.quantMax = 3;
		Espiral.numEsp += 1;
		this.produtos = new ArrayList<Produto>();
		this.nomeProd = nomeProd;
		//this.preco = preco;
	}
	
	public int getQuantMax() {
		return quantMax;
	}
	public static int getNumEsp() {
		return numEsp;
	}
	public List<Produto> getProd() {
		return produtos;
	}
	public String getNomeProd() {
		return nomeProd;
	}
	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}
	/*public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}*/
	
	public boolean addProduto(Produto prod) throws Exception {
		for (Produto cod: produtos) {
			if(cod.cod == prod.cod) {
				throw new Exception("Código de Produto já existente");
			}
		}
		return this.produtos.add(prod);
	}
	
	public boolean rmProduto(int cod) throws Exception {
		for (Produto codProd : produtos) {
			if(codProd.cod == cod) {
				return this.produtos.remove(codProd);
			}
		}
		throw new Exception("Código do Produto não encontrado");
	}

	@Override
	public String toString() {
		return "Espiral [produtos=" + produtos + ", nomeProd=" + nomeProd + "]";
	}

	
	
}
