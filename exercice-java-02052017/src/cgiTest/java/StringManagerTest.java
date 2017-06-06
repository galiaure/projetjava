package cgiTest.java;

import java.util.ArrayList;
import java.util.List;

import cgi.java.StringManager;
import cgi.java.User;

public class StringManagerTest {

	public static void main(String[] args) {
		User user1 = new User(1,"grouleaud","quentin");
		User user2 = new User(25,"DUPONT","BERNARD");
		User user3 = new User(12,"DISTOU","LEO");
		User user4 = new User(94,"grouleaud","denis");
		User user5 = new User(6,"distou","léa");
		
		//Instanciation de la classe StringManager
		StringManager sm = new StringManager();
		
		String[] tab = sm.transformUser(user1);
		
		for(String s:tab){
			System.out.println(s);
		}
		// Ajout de mes Users dans une liste
		List<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		
		User.printListUser(users);
		
	}
}
