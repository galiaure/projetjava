package hb.asserts;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

public class TestAssertions {

	@Test
	public void testEmptyBuffer() {
		StringBuffer sb = new StringBuffer();
		String stringBuffer = sb.toString();
		int length = sb.length();
		
		assertTrue(stringBuffer.equals(""));
		assertTrue(length == 0);
	}
	
	@Test
	public void testFullBuffer() {
		StringBuffer buffer = new StringBuffer("c'est cool junit");
		
		String stringBuffer = buffer.toString();
		int length = stringBuffer.length();
		
		assertFalse(stringBuffer.equals(""));
		assertFalse(length == 0);
	}
	
	@Test
	public void testAssertEquals() {
		int number1 = 5;
		int number2 = 10;
		int number = number1 + number2;
		
		assertEquals(15, number);
	}
	
	@Test
	public void testAssertNotEquals() {
		int number1 = 5;
		int number2 = 10;
		int number = number1 + number2;
		
		assertNotEquals(5, number);
	}
	
	@Test
	public void testAssertNotNull() {
		User user = new User("quentin","motdepasse");
		assertNotNull(user);
	}
	
	@Test
	public void testAssertNull() {
		Date date = null;
		assertNull(date);
	}
	
	@Test
	public void testAssertSame() {
		String string = "quentin";
		assertSame("quentin", string);
	}
	
	@Test
	public void testAssertNotSame() {
		String string = "quentin";
		assertNotSame("cynthia", string);
	}
	
	@Test
	public void testAssertArrayEquals() {
		int[] tableau1 = {1, 2, 3, 4, 5};
		int[] tableau2 = {1, 2, 3, 4, 5};
		assertArrayEquals(tableau2, tableau1);
	}
	
	@Test
	public void testAssertThatUser() {
		User user1 = new User("root","root");
		User user2 = new User("root","root");
		
		//assertEquals(user1, user2); //false
		//assertSame(user1, user2); //false
		
		assertThat(user1, MatcherUser.myEquals(user2));
	}
	
	
	

}
