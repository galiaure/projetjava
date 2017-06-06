package hb.tests;

import java.util.Arrays;
import java.util.Calendar;

import hb.pojos.Flower;
import hb.services.FlowerService;
import hb.services.impl.FlowerServiceImpl;

public class FlowerServiceTest {

	public static void main(String[] args) {
		
		FlowerService fs = new FlowerServiceImpl();
		
		System.out.println("Couleurs : "+fs.getDistinctColorsOfFlowers());
		Calendar c = Calendar.getInstance();
		c.set(2017, 4, 20);
		System.out.println("Fleurs expirant après le 20/05/2017 : ");
		for(Flower f:fs.getFlowersByExpiryDate(c.getTime())){
			System.out.println(f);
		}
		System.out.println("Liste des noms de fleurs : \n"+Arrays.toString(fs.getFlowersName()));
		System.out.println("Fleurs de couleurs rouge : \n"+Arrays.toString(fs.getNameFlowersByColor("rouge")));
		System.out.println("Nombre de fleurs : "+fs.getNumberOfFlowers());
		System.out.println("Liste des fleurs contenant li :");
		for(Flower f:fs.getSomeFlowersByNamePart("li")){
			System.out.println(f);
		}
		System.out.println("taille des noms de fleurs : "+Arrays.toString(fs.getSizeOfFlowersName()));

	}

}
