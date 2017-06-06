package hb.tdd.test;

import static org.junit.Assert.*;

import org.junit.Test;

import hb.tdd.Operation;

public class OperationTest {

	@Test
	public void testAddition() {
		int result = Operation.addition(7, 7);
		
		assertEquals(14, result);
	}

}
