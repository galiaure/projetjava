package hb.junits;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import hb.services.SatelliteService;
import hb.services.impl.SatelliteServiceImpl;
import hb.utils.DataConnect;

public class SatelliteServiceTest {
	
	private SatelliteService ss;
	
	@Before
	public void init(){
		ss = new SatelliteServiceImpl(DataConnect.getConnection());
	}
	
	@Test
	public void testGetSatelliteByPlanet(){
		assertEquals(1, ss.getSatelliteByPlanet("Terre").size());
	}
	
	@Test
	public void testGetSatelliteObject(){
		assertEquals(40, ss.getSatelliteObject().size());
	}

}
