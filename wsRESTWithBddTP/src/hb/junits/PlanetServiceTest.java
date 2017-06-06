package hb.junits;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hb.services.PlanetService;
import hb.services.impl.PlanetServiceImpl;
import hb.utils.DataConnect;

public class PlanetServiceTest {
	
	private PlanetService ps;
	
	@Before
	public void init(){
		ps = new PlanetServiceImpl(DataConnect.getConnection());
	}

	@Test
	public void testGetPlanets() {
		assertEquals(13, ps.getPlanets().size());
	}
	
	@Test
	public void testFindPlanetsByType(){
		assertEquals(5, ps.findPlanetsByType("naine").size());
	}

}
