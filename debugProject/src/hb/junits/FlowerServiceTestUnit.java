package hb.junits;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import hb.pojos.Flower;
import hb.services.FlowerService;
import hb.services.impl.FlowerServiceImpl;

public class FlowerServiceTestUnit {
	//Atribut
	private FlowerService flowerService;
	
	@Before
	public void runBeforeEveryTest() {
		flowerService = new FlowerServiceImpl();
	}
	
	@Test
	public void testGetFlowersName(){
		String[] names = flowerService.getFlowersName();
		System.out.println("-----Test GetFlowersName-----");
		for(String name:names){
			System.out.println(name);
		}
		
		String[] namesExpected = {"Jacinthe","Lilas","Marguerite","Orchidée","Rose","Tulipe","Violette"};
		assertArrayEquals(namesExpected,names);
	}
	
	@Test
	public void testGetNumberOfFlowers(){
		int num = flowerService.getNumberOfFlowers();
		System.out.println("-----Test GetNumberOfFlowers-----");
		System.out.println(num);
		assertEquals(7,num);
	}
	
	@Test
	public void testGetNameFlowersByColor(){
		String colors[] = flowerService.getNameFlowersByColor("rouge");
		System.out.println("-----Test GetNameFlowersByColor-----");
		for(String color:colors){
			System.out.println(color);
		}
		String[] colorsExpected = {"Jacinthe","Rose"};
		assertArrayEquals(colorsExpected,colors);
	}
	
	@Test
	public void testGetSizeOfFlowersName(){
		int[] numget = flowerService.getSizeOfFlowersName();
		System.out.println("-----Test GetSizeOfFlowersName-----");
		for(int num:numget){
			System.out.println(num);
		}
		int[] numExpected = {4,6,8,8,5,8,10};
		assertArrayEquals(numExpected,numget);
	}
	
	@Test
	public void testGetFlowersByExpiryDate(){
		Calendar c = Calendar.getInstance();
		c.set(2017, 4,20);
		List<Flower> flowers = flowerService.getFlowersByExpiryDate(c.getTime());
		System.out.println("-----Test GetFlowersByExpiryDate-----");
		for(Flower f:flowers){
			System.out.println(f);
		}
		
	}

}
