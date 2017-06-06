package hb.services;

import java.util.List;

import hb.pojos.Satellite;

public interface SatelliteService {
	
	public List<String> getSatelliteByPlanet(String planetName);
	public List<Satellite> getSatelliteObject();
	

}
