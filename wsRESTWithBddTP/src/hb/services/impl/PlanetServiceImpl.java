package hb.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hb.pojos.Planet;
import hb.services.PlanetService;
import hb.utils.Consts;

public class PlanetServiceImpl implements PlanetService {
	
	private Connection con;
	
	public PlanetServiceImpl(Connection con){
		this.con = con;
	}

	@Override
	public List<Planet> getPlanets() {
		List<Planet> planets = null;
		try {
			ResultSet rs = con.createStatement().executeQuery(Consts.GET_PLANETS_QUERY);
			planets = new ArrayList<Planet>();
			while(rs.next()){
				Planet p = new Planet(); 
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescription(rs.getString("description"));
				p.setType(rs.getString("type"));
				planets.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return planets;
	}

	@Override
	public List<String> findPlanetsByType(String type) {
		List<String> planets = null;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(Consts.GET_PLANETS_NAME_BY_TYPE_QUERY);
			ps.setString(1, type);
			planets = new ArrayList<String>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				planets.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return planets;
	}

}
