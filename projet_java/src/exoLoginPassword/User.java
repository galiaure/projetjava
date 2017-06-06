package exoLoginPassword;
/*Enoncé exercice login/password Créer une classe User 
 * avec 2 attributs login/password. Créer une classe 
 * UserNotFoundException. Créer une classe UserService 
 * qui a un attribut Map avec 3 utilisateurs root/root saf/saf dodo/dodo. 
 * Implémenter une méthode public boolean isUserAuthorized (User u)  
 * throws UserNotFoundException. Renvoie true si le couple 
 * login/password existe. soulève une UserNotFoundException 
 * si le login n'existe pas. Idem si le password n'est pas correct.
 */

public class User {
	private String login;
	private String password;

	public User(String login,String password) {
		this.login = login;
		this.password = password;
	}

	public boolean isUserAuthorized (User u) throws UserNotFoundException {
		/* Renvoie true si le couple login/password existe. soulève une UserNotFoundException 
		 * si le login n'existe pas. Idem si le password n'est pas correct.*/
		
		for(int i = 0; i< us.size();i++){
			
			if (us.contains(u)){
				
			}
		}
		
		

	


	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + "]";
	}



}
