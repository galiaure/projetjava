package cgi.java;

import cgi.java.User;

public class StringManager {
	
	public String[] transformUser(User user){
		String tab[] = new String[3];
		tab[0] = String.valueOf(user.getId());
		tab[1] = user.getLastname();
		tab[2] = user.getLogin();
		return tab;
	}
	
	public  getUserWithMajAttr( User userMin) {
		
	}

}
