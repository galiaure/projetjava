package com.humanbooster.junit.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.humanbooster.jdbc.managers.UserManager;
import com.humanbooster.jdbc.objects.User;
import com.humanbooster.jdbc.utils.DataConnect;

public class UserManagerTest {
	private UserManager userManager;
	private Connection connection;
	private User userForTest;
	private User userDeleteForTest;

	
	@Before
	public void runBeforeEveryTest() {
		try{
			connection = DataConnect.getConnection();
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		userManager = new UserManager(connection);
		userForTest =new User("test","tototititata");
		userDeleteForTest = new User("suprime","delete");
	}
	
	@Test
	public void testGetUser(){
		User user = userManager.getUser(userForTest.getLogin());
		assertNotNull(user);
		assertTrue(user.getLogin().equals("test"));
		assertTrue(user.getPassword().equals("tototititata"));
	}
	
	@Test
	public void testCreateUser(){
		int numberOfUsersBeforeCreation = userManager.getNumberOfUser();
		boolean isCreated = userManager.createUser(new User("safinette","safinette"));
		assertTrue(isCreated);
		int numberOfUsersAfterCreation = userManager.getNumberOfUser();
		assertEquals(numberOfUsersBeforeCreation+1,numberOfUsersAfterCreation);
	}
	
	@Test
	public void testUpdateUser(){
		boolean isUpdated = userManager.updateUser("safinette", "safinette");
		assertTrue(isUpdated);
		User userBDD = userManager.getUser("test");
		assertTrue(userBDD.getPassword().equals("toutoutoutou"));		
	}
	
	@Test
	public void testDeleteUser(){
		int numberOfUsersBeforeDelete = userManager.getNumberOfUser();
		boolean isDelete = userManager.deleteUser("suprime");
		assertTrue(isDelete);
		int numberOfUsersAfterDelete = userManager.getNumberOfUser();
		assertEquals(numberOfUsersBeforeDelete,numberOfUsersAfterDelete+1);
	}
	
	@After
	public void runAfterEveryTest() {
		DataConnect.closeConnection(connection);
		userManager = null;
	}
	
	

}
