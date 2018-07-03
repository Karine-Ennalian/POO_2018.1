
public class Gerenciador {
	private Repositorio<User> usuarios;
	private User user;
	
	public Gerenciador(Repositorio<User> usuarios) {
		this.usuarios = usuarios;
		user = null;
	}
	
	public void Login(String usuario, String password) {
		if(user != null)
			throw new RuntimeException("fail: Ja existe alguem logado");
		if(!usuarios.get(usuario).matchPassword(password)) 
		   throw new RuntimeException("fail: senha invalida ou pessoa nao encontrada");
		this.user = usuarios.get(usuario);
	}

	public void Logout() {
		if(user == null)
		    throw new RuntimeException("fail: não está ninguem logado");
		System.out.println("ok");
		this.user = null;
	}
	
	public User getUser() {
		if(user == null)
			throw new RuntimeException("fail: não está ninguem logado");
		return user;
	}
}
