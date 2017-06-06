package hb.junits;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import hb.utils.DataConnect;

public class DataConnectTest {

	@Test
	public void testGetConnection() {	
		try {
			assertNotNull(DataConnect.getConnection());
			assertTrue(DataConnect.getConnection().getCatalog().equals("solarsystem"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
