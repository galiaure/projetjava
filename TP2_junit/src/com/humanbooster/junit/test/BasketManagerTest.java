package com.humanbooster.junit.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

import com.humanbooster.jdbc.managers.BasketManager;
import com.humanbooster.jdbc.objects.Basket;
import com.humanbooster.jdbc.utils.DataConnect;
import com.humanbooster.jdbc.utils.MatcherBasket;


import junit.framework.TestSuite;
import junit.framework.TestCase;

public class BasketManagerTest extends TestCase {

	//Attribut
	private BasketManager basketManager;
	private Connection connection;
	private Basket basketForTest;


	//Connexion
	public BasketManagerTest (String testName){
		super(testName);
		try{
			connection = DataConnect.getConnection();
			basketManager = new BasketManager (connection);

			//String brand, String color, double price
			basketForTest = new Basket("nike","rouge",55);
			basketForTest.setDate(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		}catch (SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	//Constructeur
	public void testCreateBasket(){
		int numberOfBasketBeforeCreation = basketManager.getNumberOfBasket();
		boolean isCreated = basketManager.createBasket(basketForTest);
		assertTrue(isCreated);
		int numberOfBasketAfterCreation = basketManager.getNumberOfBasket();
		assertEquals(numberOfBasketBeforeCreation+1,numberOfBasketAfterCreation);
	}

	public void testgetAll(){
		int numberOfBasket = basketManager.getNumberOfBasket();
		int numberOfBasketGet = basketManager.getAll().size();
		assertEquals(numberOfBasket,numberOfBasketGet);
	}

	//PAS OK
	public void testgetBasketById(){
		Basket basket = basketManager.getBasketById(basketForTest.getId());
		//assertNotNull(basket);
		assertThat(basket, MatcherBasket.myEquals(basketForTest));
	}

	public void testDeleteBasket(){
		int numberOfBasketBeforeDelete = basketManager.getNumberOfBasket();
		boolean isCreated = basketManager.deleteBasket(1);
		assertTrue(isCreated);
		int numberOfBasketAfterDelete = basketManager.getNumberOfBasket();
		assertEquals(numberOfBasketBeforeDelete,numberOfBasketAfterDelete+1);
	}

	public void testdeleteAllBasket(){
		int numberOfBasketBeforeDelete = basketManager.getNumberOfBasket();
		boolean isCreated = basketManager.deleteAll();
		assertTrue(isCreated);
		int numberOfBasketAfterDelete = basketManager.getNumberOfBasket();
		assertEquals(numberOfBasketBeforeDelete,numberOfBasketAfterDelete+numberOfBasketBeforeDelete);
	}


	//Fin de connexion
	public void runAfterEveryTest() {
		DataConnect.closeConnection(connection);
		basketManager = null;
	}
	//Ordre des tests
	public static junit.framework.Test suite() {
		TestSuite suite = new TestSuite("Test BasketManagerTest");
		suite.addTest(new BasketManagerTest("testCreateBasket"));
		suite.addTest(new BasketManagerTest("testgetBasketById"));
		suite.addTest(new BasketManagerTest("testgetAll"));
		suite.addTest(new BasketManagerTest("testDeleteBasket"));
		suite.addTest(new BasketManagerTest("testdeleteAllBasket"));
		suite.addTest(new BasketManagerTest("runAfterEveryTest"));
		return suite;
	}


}
