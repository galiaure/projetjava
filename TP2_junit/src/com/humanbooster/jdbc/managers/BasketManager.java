
package com.humanbooster.jdbc.managers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.humanbooster.jdbc.objects.Basket;
import com.humanbooster.jdbc.objects.User;
import com.humanbooster.jdbc.utils.Consts;

public class BasketManager {
	private Connection connection;
	private static Logger logger = Logger.getLogger(BasketManager.class);
	
	public BasketManager(Connection connection){
		this.connection = connection;
		String log4jConfPath = Consts.LOG4J_CONF_PATH;
		PropertyConfigurator.configure(log4jConfPath);
	}
	
	/**
	 * Méthode pour créer une Basket dans la BDD
	 * @param basket basket à créer
	 * @return boolean true si création ok false si création ko
	 */
	public boolean createBasket(Basket basket){
		boolean isCreationOk = false;
		try{
			PreparedStatement ps = connection.prepareStatement(
									Consts.BASKET_CREATION_QUERY);
			ps.setString(1, basket.getBrand());
			ps.setString(2, basket.getColor());
			ps.setDouble(3, basket.getPrice());
			ps.setDate(4, basket.getDate());
	
			logger.info(basket.getDate());
				
			ps.executeUpdate();
			isCreationOk = true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return isCreationOk;
		
	}
	
	/**
	 * Récupérer des baskets à partir de la marque
	 * @param brand
	 * @return Basket 
	 */
	public List<Basket> findBasket (String brand){
		logger.info(brand);
		List<Basket> baskets = null;
		try{
			baskets = new ArrayList<Basket>();
			PreparedStatement ps = connection.prepareStatement(
							Consts.SELECT_BASKET_BY_BRAND_QUERY);
			ps.setString(1,brand);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Basket b = new Basket(
					rs.getString(2),rs.getString(3),rs.getDouble(4));
				b.setId(rs.getInt(1));
				baskets.add(b);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return baskets;
	}
	
	/**
	 * Méthode pour récupérer le nombre de Basket
	 * @return int nombre de Basket
	 */
	public int getNumberOfBasket(){
		int nbBasket = -1;
		try{
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery(Consts.NB_BASKET_QUERY);
			
			rs.next();
			nbBasket = rs.getInt(1);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return nbBasket;
	}
	
	/**
	 * méthode permettant de récupérer l'id le plus élevé dans la table basket
	 * @return l'id le plus élevé de la table basket
	 */
	public int getLastBasketId(){
		int maxId = -1;
		try{
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(
						Consts.GET_LAST_BASKET_QUERY);
			rs.next();
			maxId =  rs.getInt(1);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return maxId;
	}
	
	/**
	 * Méthode pour récupérer une Basket à partir de son id dans la BDD
	 * @param id
	 * @return Basket 
	 */
	public Basket getBasketById(int id){
		logger.info(id);
		Basket b = null;
		try{
			PreparedStatement ps = connection.prepareStatement(
									Consts.GET_BASKET_BY_ID_QUERY);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				String brand = rs.getString(2);
				String color = rs.getString(3);
				double price = rs.getDouble(4);	
				Date date = rs.getDate(6);
				b = new Basket(brand,color,price);
				b.setId(id);
				b.setDate(date);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return b;
	}
	
	/**
	 * Méthode pour mettre à jour une Basket à partir de son identifiant
	 * On met à jour le stock et la couleur de la basket
	 * @param id
	 * @param stock
	 * @param color
	 * @return boolean true si update ok false si update ko
	 */
	public boolean updateBasket(int id, double price, String color){
		logger.info(id+","+price+","+color);
		boolean updateOk = false;
		try{
			PreparedStatement ps = connection.prepareStatement(
						Consts.UPDATE_PRICE_BRAND_OF_BASKET_QUERY);
			ps.setDouble(1,  price);
			ps.setString(2, color);
			ps.setInt(3, id);
			ps.executeUpdate();
			updateOk = true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return updateOk;
	}
	
	/**
	 * Méthode permettant de récupérer toutes les baskets
	 * de la BDD
	 * @return List baskets trouvées
	 */
	public List<Basket> getAll(){
		List<Basket> baskets = null;
		try{
			baskets = new ArrayList<Basket>();
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery(Consts.GET_ALL_BASKET_QUERY);
			while(rs.next()){
				Basket b = new Basket(rs.getString(2),rs.getString(3),rs.getDouble(4));
				b.setId(rs.getInt(1));
				baskets.add(b);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return baskets;
	}
	
	/**
	 * Méthode permettant de supprimer une basket à partir de son id 
	 * dans la BDD
	 * @param id Identifiant de la Basket à supprimer
	 * @return boolean true si suppression ok false si suppression ko
	 */
	public boolean deleteBasket(int id){
		logger.info(id);
		boolean isDeleteOk = false;
		try{
			PreparedStatement ps = connection.prepareStatement(
								Consts.DELETE_BASKET_BY_ID_QUERY);
			ps.setInt(1, id);
			ps.execute();
			isDeleteOk = true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return isDeleteOk;
	}
	
	/**
	 * Méthode pour supprimer toutes les baskets de la BDD
	 * @return boolean true si suppression ok false si suppression ko
	 */
	public boolean deleteAll(){
		boolean deleteAllOk = false;
		try{
			Statement statement = connection.createStatement();
			statement.execute(Consts.DELETE_ALL_BASKET_QUERY);
			statement.execute(Consts.RESET_AUTO_INCREMENT_BASKET_QUERY);
			deleteAllOk = true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return deleteAllOk;
	}
	
	/**
	 * Méthode permettant de créer plusieurs Baskets
	 * dans la BDD
	 * @param baskets List des Baskets à créer
	 */
	public boolean createBaskets(List<Basket>baskets){
		boolean creationOk = false;
		Iterator<Basket> i = baskets.iterator();
		try{
			while (i.hasNext()){
				String query = Consts.CREATE_SIMPLE_BASKET_QUERY;
				
				PreparedStatement ps = connection.prepareStatement(query);
				
				Basket b = i.next();
				ps.setString(1, b.getBrand());
				ps.setString(2, b.getColor());
				ps.setDouble(3, b.getPrice());
					
				ps.executeUpdate();	
			}
			creationOk = true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return creationOk;
	}
	
	/**
	 * Méthode pour mettre à jour plusieurs Baskets en même temps
	 * @param List Liste des baskets à mettre à jour
	 * 
	 */
	public boolean updateBaskets(List<Basket>baskets){
		boolean updateOk = false;
		try{
			Iterator<Basket> iterator = baskets.iterator();
			while(iterator.hasNext()){
				Basket b = iterator.next();
				PreparedStatement ps = connection.prepareStatement(
								Consts.UPDATE_COLOR_OF_BASKET_QUERY);
				ps.setString(1, b.getColor());
				ps.setString(2, b.getBrand());
				ps.setDouble(3, b.getPrice());
				ps.executeUpdate();
			}
			updateOk = true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return updateOk;
		
	}
	
	/**
	 * Méthode permettant de créer une basket en lui associant
	 * un utilisateur
	 * @param basket basket à créer
	 * @param user utilisateur qu'on veut associer à la basket
	 */
	public boolean createBasketWithUser(Basket basket, User user){
		boolean isCreationOk = false;
		try{
			PreparedStatement ps = connection.prepareStatement(
							Consts.CREATE_BASKET_WITH_USER_QUERY);
			ps.setString(1, basket.getBrand());
			ps.setString(2, basket.getColor());
			ps.setDouble(3, basket.getPrice());
			ps.setString(4, user.getLogin());
			ps.setDate(5, basket.getDate());
		
			ps.executeUpdate();
			isCreationOk = true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return isCreationOk;
	}
	
	/**
	 * Méthode permettant de récupérer des baskets dont la date de mise en stock
	 * est > à celle passée en paramètre.
	 * @param date
	 * @return List liste des baskets 
	 */
	public List<Basket> getBasketAfterDate(Date date){
		List<Basket> baskets = null;
		//select * from basket where basket_date > '2015-11-03';
		try{
			baskets = new ArrayList<Basket>();
			PreparedStatement ps = connection.prepareStatement(
							Consts.GET_BASKETS_BY_DATE_QUERY);
			ps.setDate(1, date);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Basket b = new Basket(
						rs.getString(2),rs.getString(3),rs.getDouble(4));
				b.setDate(rs.getDate(6));
				baskets.add(b);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return baskets;
	}
}
