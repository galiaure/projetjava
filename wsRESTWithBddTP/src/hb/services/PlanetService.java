package hb.services;

import java.util.List;

import hb.pojos.Planet;

public interface PlanetService {
	
	List<Planet> getPlanets();
	List<String> findPlanetsByType(String type);

}
