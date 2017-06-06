package hb.tests;
import java.util.Arrays;
import java.util.Calendar;

import hb.pojos.Flower;
import hb.services.FlowerService;
import hb.services.impl.FlowerServiceImpl;

public class FlowerServiceTest {

	public static void main(String[] args) {
		
		FlowerService fs = new FlowerService();
		
		System.out.println("couleurs : "+fs.getDistinctColorsOfFlowers());
		Calendar c = Calendar.getInstance();
		c.set(2017, 5, 20);
		System.out.println(" fleurs expirant après le 20/04/2017 : ");
		for(Flower f:fs.getFlowersByExpiryDate(c.getTime())){
			System.out.println(f);
		}
		System.out.println("Liste des noms de fleurs : "+Arrays.toString(fs.getFlowersName()));
		System.out.println("fleurs de couleurs rouge : "+Arrays.toString(fs.getNameFlowersByColor("rouge")));
		System.out.println("nombre de fleurs : "+fs.getNumberOfFlowers());
		System.out.println("Liste des fleurs contenant li :");
		for(Flower f:fs.getSomeFlowersByNamePart("li")){
			System.out.println(f);
		}
		System.out.println("taille des noms de fleurs : ");
		for(int i :fs.getSizeOfFlowersName()){
			System.out.println(i);;
		}

	}

}
