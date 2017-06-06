package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import object.User;

public class UserManager {
	private Connection con;

	public UserManager(Connection con) {
		this.con = con;

	}

	public boolean createUser(User user){
		String query = "INSERT INTO user VALUES (?,?)";
		boolean isCreated = false;
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
			ps.executeUpdate();
			isCreated=true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return isCreated;
	}


	// Version prepare Statement
	public User getUser2(String login) {
		User user = null;
		String query = "SELECT *FROM user WHERE login = ?";

		try {
			PreparedStatement ps2 = con.prepareStatement(query);
			ps2.setString(1, login);
			ResultSet rs = ps2.executeQuery();

			if(rs.next()){
				user = new User(rs.getString(1),rs.getString(2));

			}
		}catch(SQLException e){
			e.printStackTrace();
		} return user;
	}

	// Version create Statement
	public User getUser(String login){
		User user = null;
		String query = "SELECT * FROM user WHERE login = '"+login+"'";
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()){
				user = new User(rs.getString(1),rs.getString(2));
			};
		}catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}

	public boolean updateUser2(String login, String password){
		boolean updateOk = false;
		String query = "UPDATE user SET password = '"+password+"' WHERE login = '"+login+"'";
		try{
			Statement stmt = con.createStatement();
			stmt.execute(query);
			updateOk = true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return updateOk;

	}


	public boolean updateUser(String login, String password){
		boolean updateOk = false;
		String query = "UPDATE user SET password = ? WHERE login = ?";
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, password);
			ps.setString(2, login);
			ps.execute();
			updateOk = true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return updateOk;

	}

	public boolean deleteUser(String login){
		boolean deleteOk = false;
		String query = "DELETE FROM user WHERE login = '"+login+"'";
		try{
			Statement stmt = con.createStatement();
			stmt.execute(query);
			deleteOk = true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return deleteOk;
	}

	public int getNumberOfUsers(){
		int result = 1;
		String query = "SELECT * FROM user";
		try{
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			rs.next();
			result = rs.getInt("count(*)");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	public List<User> getAllUsers(){
		List<User> users = null;
		String query = "SELECT * FROM user";
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			users = new ArrayList<User>();
			while(rs.next()){
				User u = new User(rs.getString("login"), rs.getString("password"));
				users.add(u);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return users;	
	}
	
	public User[] getAllUsers2(){
        User[] users = null;
        String query = "SELECT * from user";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.last();
            int nbUsers = rs.getRow();
            users = new User[nbUsers];
            rs.beforeFirst();
            nbUsers = 0;
            
            while(rs.next()){
                User u = new User(rs.getString("login"),rs.getString("password"));
                users[nbUsers] = u;
                nbUsers++;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return users;   
    }



}