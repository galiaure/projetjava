package clients;


import java.sql.Connection;
import java.sql.SQLException;

import manager.DataConnect;
import manager.UserManager;
import object.User;

public class UserClient {

	public static void main(String[] args) {
		Connection con = null;
		try{
			con = DataConnect.getConnection();
			
			System.out.println("---------------TEST CONNEXION---------------\n");
			System.out.println(" Connection: "+con);
			
			// Creation d'un nouveau utilisateur
			User user = new User("test","safinette");
			User user2 = new User("quentin","superpro");
			User user3 = new User("toto","tata");
			System.out.println("---------------TEST CREATION---------------\n");
			
			UserManager um = new UserManager(con);
			// une foi r�aliser je masque
			//um.createUser(user);
			
			// Recherche 
			System.out.println("---------------TEST RECUPERATION---------------\n");
			System.out.println(um.getUser("quentin"));
			System.out.println("user2: "+um.getUser2("test"));
			
			//mise a jour d'un user
			
			System.out.println("---------------TEST MISE A JOUR USER---------------\n");
			System.out.println(um.updateUser("test","supermdp"));
			System.out.println(um.getUser("test"));
			
			System.out.println("Update2: "+um.updateUser2("test","tototititata"));
			System.out.println(um.getUser2("test"));
			
			//suppression d'un user
			System.out.println("---------------TEST suppression USER---------------\n");
			um.deleteUser("toto");
			System.out.println(um.getUser("toto"));
			
			
			
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}finally{
			DataConnect.closeConnection(con);
		}
		

	}

}
