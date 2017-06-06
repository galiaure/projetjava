package cgi.junits;

import static org.junit.Assert.*;

import java.time.Year;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import cgi.exceptions.BadLimitException;
import cgi.pojos.DoubleKey;
import cgi.pojos.WeightRoom;
import cgi.services.WeightRoomService;
import cgi.services.impl.WeightRoomServiceImpl;
public class WeightRoomServiceTest {
	
	private WeightRoomService wrs;

	@Before
	public void runBeforeEveryTest() {
		WeightRoom<Integer> wr1 = new WeightRoom<Integer>("Basic Fit","3 rue pasteur 69000 Lyon","18/09/2013",80);
		WeightRoom<String> wr2 = new WeightRoom<String>("Appart Fitness","35 rue de la r�publique 69000 Lyon",
				"19/10/2014","salle canon");
		WeightRoom<String> wr3 = new WeightRoom<String>("Elixia","10 rue toto 59000 Lille",
				"12/05/2012","salle extraordinaire");
		WeightRoom<Integer> wr4 = new WeightRoom<Integer>("Oc�a","3 rue de la r�publique 69000 Lyon",
				"22/03/2012",70);
		WeightRoom<String> wr5 = new WeightRoom<String>("Lady fitness","90 rue de la r�publique 69000 Lyon",
				"11/01/2014","salle magique");
		WeightRoom[] data = new WeightRoom[5];
		data[0] = wr1;
		data[1] = wr2;
		data[2] = wr3;
		data[3] = wr4;
		data[4] = wr5;
		wrs = new WeightRoomServiceImpl(data);
	}
	
	@Test
	public void testGetKeys(){
		Set<DoubleKey> keys = wrs.getKeys();
		for(DoubleKey dk:keys){
			assertTrue(dk.getKey1()>0 && dk.getKey1()<100 );
			assertTrue(dk.getKey2()>0 && dk.getKey2()<100 );
		}
	}
	 
	
	@Test
	public void testGetRoomNames(){
		String roomName = wrs.getRoomNames();
		System.out.println("----- Test RoomNames-----");
		System.out.println(roomName);
		System.out.println(roomName.length());
		
		
		assertEquals(49,roomName.length());
		assertTrue(roomName.contains("Lady"));
		assertTrue(roomName.contains("fitness"));
		assertTrue(roomName.contains("Basic Fit"));
		assertTrue(roomName.contains("Elixia"));
		assertTrue(roomName.contains("Oc�a"));
		
	}
	
	@Test
	public void testGetValues(){
		Collection<WeightRoom<?>> roomName = wrs.getValues();
		System.out.println("----- Test GetValues-----");
		System.out.println(roomName);
		assertEquals(5,roomName.size());
		
		for(WeightRoom<?> wr : roomName){
			assertTrue(wr.getAddress().contains("rue"));
		}
	}
	
	@Test
	public void testGetRoomWithArea(){
		List<String> rooms = wrs.getRoomWithArea();
		System.out.println("----- Test GetRoomWithArea-----");
		System.out.println(rooms);
		assertEquals(2,rooms.size());
		assertTrue(rooms.contains("|Oc�a|"));
		assertTrue(rooms.contains("|Basic Fit|"));
	}
	
	@Test
	public void testGetNbRoomsWithDesc(){
		int desc = wrs.getNbRoomsWithDesc();
		System.out.println("----- Test GetNbRoomsWithDesc-----");
		System.out.println(desc);
		assertEquals(3,desc);
	}
	
	@Test
	public void testGetSomeWeightRoomAddresses(){
		Vector<String> adress = null;
		Vector<String> vectorException = null;
		try {
			adress = wrs.getSomeWeightRoomAddresses(5);
			assertTrue(adress.contains("3 rue de la r�publique 69000 Lyon"));
			assertEquals(5,adress.size());
			vectorException = wrs.getSomeWeightRoomAddresses(7);
		} catch (BadLimitException e) {
			System.out.println("SGSG vectorException "+vectorException);
			assertNull(vectorException);
			e.printStackTrace();
		}
		System.out.println("----- Test GetSomeWeightRoomAddresses-----");
		System.out.println(adress);	
	}
	
	@Test
	public void testGetOpeningDatesByYear(){
		Year y = Year.of(2012);
		String openingDates = wrs.getOpeningDatesByYear(y);
		System.out.println("----- Test GetOpeningDatesByYear-----");
		System.out.println(openingDates);
		System.out.println(openingDates.length());
		
		assertEquals(22,openingDates.length());
		assertTrue(openingDates.trim().equals("2012-05-12 2012-03-22"));
		assertTrue(openingDates.contains("2012-05-12"));
		assertTrue(openingDates.contains("2012-03-22"));
		
		
	}
	
}

