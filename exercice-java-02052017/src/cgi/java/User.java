package cgi.java;

import java.util.List;

public class User {
	private int id;
	private String lastname;
	private String login;
	
	public User( int id, String lastname, String login){
		this.id = id;
		this.lastname = lastname;
		this.login = login;
		
	}
	
	public boolean testStringEqualityIgnoreCase(String lastname, String login){
		if(lastname.equalsIgnoreCase(login)){
			return true;
		}else{
			return false;
		}
	}
	
	public static void printListUser(List<User> users){
		for(User user: users){
			System.out.println(user);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", lastname=" + lastname + ", login=" + login + "]";
	}
	
}
