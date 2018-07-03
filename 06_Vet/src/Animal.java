public class Animal {

	public int animalId;
    public String nome;
	public String especie;
	public Dono dono;
	
	public Animal(int animalId, String nome, String especie, Dono dono) {
		this.animalId = animalId;
		this.nome = nome;
		this.especie = especie;
		this.dono = dono;
	}
	
	public String toString() {
		return "Animal: " + animalId+ " : " + nome + " : " + especie + " : " + dono;
	}
}