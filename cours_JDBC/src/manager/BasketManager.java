package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import object.Basket;

public class BasketManager {
	private Connection con;

	public BasketManager(Connection con) {
		this.con = con;

	}
	
	public boolean createBasket(Basket basket){
		String query = "INSERT INTO basket VALUES (?,?,?,?)";
		boolean isCreated = false;
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, basket.getBrand());
			ps.setString(2, basket.getColor());
			ps.setInt(3, basket.getPrice());
			ps.setString(4, basket.getLogin());
			ps.executeUpdate();
			isCreated=true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return isCreated;
	}
	
	public List<Basket> findBasket(String brand) {
		Basket basket = null;
		String query = "SELECT *FROM user WHERE brand = ?";

		try {
			PreparedStatement ps2 = con.prepareStatement(query);
			ps2.setString(1, brand);
			ResultSet rs = ps2.executeQuery();

			if(rs.next()){
				basket = new Basket(rs.getString(1),rs.getString(2));

			}
		}catch(SQLException e){
			e.printStackTrace();
		} return user;
	}
	
	
	 

}
