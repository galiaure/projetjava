package hb.junits;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hb.pojos.Astronaut;
import hb.services.AstronautService;
import hb.services.impl.AstronautServiceImpl;
import hb.utils.DataConnect;

public class AstronautServiceTest {
	
	private AstronautService as;
	
	@Before
	public void init(){
		as = new AstronautServiceImpl(DataConnect.getConnection());
	}

	//@Test
	public void testCreateAstronaut() {
		assertTrue(as.createAstronaut(new Astronaut(1,56,"safinette","safinette")));
	}

}
