package exoLoginPassword;

import java.util.ArrayList;

public class UserService {
	private String Map;
	public static void main(String[] args) {
		// Création d'une liste
		ArrayList<User> us = new ArrayList<User>();
		
		//Ajout de nouveaux utilisateurs
		User user1 = new User("root","root");
		User user2 = new User("saf","saf");
		User user3 = new User("dodo","dodo");
		
		// Ajout dans une liste
		us.add(user1);
		us.add(user2);
		us.add(user3);
		
		// Parcour la liste
		
		for(int i = 0; i< us.size();i++){
			System.out.println("donnée à l'indice " + i + " = " + us.get(i));

		}
		
		
		


	}

}
