public class Gerenciador {

	private Repositorio<Cliente> usuarios;
	private Cliente user;
	
	public Gerenciador(Repositorio<Cliente> usuarios) {
		this.usuarios = usuarios;
		user = null;
	}
	
	public void Login(String usuario, String password) {
		if(user != null)
			throw new RuntimeException("fail: Ja existe cliente logado");
		if(!usuarios.get(usuario).matchPassword(password)) 
		   throw new RuntimeException("fail: senha invalida ou cliente nao encontrada");
		this.user = usuarios.get(usuario);
	}

	public void Logout() {
		if(user == null)
		    throw new RuntimeException("fail: nao houve login");
		System.out.println("ok");
		this.user = null;
	}
	
	public Cliente getUser() {
		if(user == null)
			throw new RuntimeException("fail: nao houve login");
		return user;
	}
	
}

