package hb.utils;

public class Consts {
	
	public static final String GET_PLANETS_QUERY = "SELECT * FROM planet";
	public static final String GET_PLANETS_NAME_BY_TYPE_QUERY = "SELECT name FROM planet WHERE type = ?";
	public static final String GET_SATELLITE_NAME_BY_PLANET_NAME_QUERY = "SELECT s.name FROM satellite s, planet p WHERE p.id = s.idPlanet and p.name =?";
	public static final String CREATE_ASTRONAUT_SERVICE_QUERY = "INSERT INTO Astronaut (id, age, lastname, firstname) VALUES (?,?,?,?)";
	public static final String GET_PLANET_BY_ID_QUERY = "SELECT * FROM planet WHERE id = ?";
	public static final String GET_SATELLITE_OBJECT_QUERY = "SELECT * FROM satellite";
}
