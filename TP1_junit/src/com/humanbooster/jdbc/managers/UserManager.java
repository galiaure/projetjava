package com.humanbooster.jdbc.managers;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.humanbooster.jdbc.objects.User;

public class UserManager{
	
	private Connection con;
	
	public UserManager(Connection con){
		this.con = con;
	}
	
	/**
	 * Méthode permettant de créer un utilisateur dans la BDD
	 * Le mot de passe est stocké en md5
	 * @param user Utilisateur à créer
	 * @boolean true si création ok false si création ko
	 * @throws SQLException
	 */
	public boolean createUser(User user){
		//String query = "INSERT INTO user VALUES (?,md5(?))";
		String query = "INSERT INTO user VALUES (?,?)";
		boolean isCreated = false;
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
			ps.executeUpdate();
			isCreated = true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return isCreated;
	}
	
	/**
	 * Méthode permettant de récupérer un utilisateur à partir de son login
	 * @param login
	 * @return User utilisateur récupéré
	 */
	public User getUser(String login){
		User user = null;
		String query = "SELECT * FROM user WHERE login = ?";
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, login);
		
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				user = new User(rs.getString(1),rs.getString(2));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * Méthode pour mettre à jour le mot de passe d'un utilisateur
	 * à partir du login
	 * @param String login login de l'utilisateur à mettre à jour
	 * @param String password nouveau password
	 */
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
	
	/**
	 * Méthode permettant de supprimer un utilisateur de la BDD
	 * à partir de son login
	 * @param login
	 * @return boolean true si suppression ok false si suppression ko
	 */
	public boolean deleteUser(String login){
		boolean deleteOk = false;
		String query = "DELETE FROM user WHERE login = ?";
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,  login);
			ps.execute();
			deleteOk = true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return deleteOk;
	}
	
	/**
	 * Méthode permettant de récupérer
	 * le nombre d'utilisateurs dans la BDD
	 * @return int nombre d'utilisateurs
	 */
	public int getNumberOfUser(){
		int result = -1;
		String query = "SELECT count(*) FROM user";
		try{
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			rs.next();
			result =  rs.getInt(1);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Méthode permettant de supprimer tous les utilisateurs
	 * de la BDD
	 * remet l'autoincrement de la table à 1
	 * @return boolean true si suppresion ok false si suppression ko
	 */
	public boolean deleteAllUser(){
		boolean deleteAllok = false;
		String query = "DELETE FROM User";
		String query2 = "ALTER TABLE user AUTO_INCREMENT = 1";
		try{
			Statement statement = con.createStatement();
			statement.execute(query);
			statement.execute(query2);
			deleteAllok= true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return deleteAllok;
	}
}
