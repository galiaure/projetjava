package hb.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import hb.pojos.Astronaut;
import hb.services.AstronautService;
import hb.utils.Consts;

public class AstronautServiceImpl implements AstronautService{
	
	private Connection con;
	
	public AstronautServiceImpl(Connection con){
		this.con = con;
	}

	@Override
	public boolean createAstronaut(Astronaut a) {
		boolean isCreated = false;
		try {
			PreparedStatement ps = con.prepareStatement(Consts.CREATE_ASTRONAUT_SERVICE_QUERY);
			ps.setInt(1, a.getId());
			ps.setInt(2, a.getAge());
			ps.setString(3, a.getFirstname());
			ps.setString(4, a.getLastname());
			ps.execute();
			isCreated = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isCreated;
	}

}
