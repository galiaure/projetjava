package cgi.java;
import static java.lang.Math.*;

import java.text.NumberFormat;
import java.util.Random;
public class Part41 {
	
	/**
	 * méthode qui permet de vérifier si une chaîne de caractère est un nombre valide
	 */
	public boolean isStringValidNumber(String chaine){
		try{
			Integer.parseInt(chaine);
			return true;
		}catch(NumberFormatException nfe) {
			nfe.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Méthode qui permet d'obtenir un int à partir d'un float
	 */
	public int arround(float number){
		return round(number);
	}
	
	/**
	 * méthode qui permet de comparer deux floats en fonction d'une tolérence
	 */
	public boolean compareFloatsWithTolerence(float f1,float f2, float tolerance){
		if (abs(f1-f2)<tolerance){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * méthode qui permet d'obtenir un nombre en pourcentage
	 */
	public String getPercentOfDouble(double number){
		NumberFormat percentFormatter = NumberFormat.getPercentInstance();
		String percent = percentFormatter.format(number);
		return percent;
	}
	
	/**
	 * méthode qui permet d'écrire la représentation binaire, 
	 * hexadecimale et octale d'un int
	 */
	public void printIntInBinaryOctalAndHexa(int number){
		System.out.println(number+" en binaire donne: "+Integer.toBinaryString(number));
		System.out.println(number+" en octale donne: "+Integer.toOctalString(number));
		System.out.println(number+" en hexa donne: "+Integer.toHexString(number));
	}
	
	/**
	 * Méthode qui permet d'obtenir un int de manière aléatoire 
	 * dans un plage donnée ex: 0 à 100
	 */
	public int getRandomInt(Random rn, int range){
		return rn.nextInt(range);
	}
	
	/**
	 * Les méthodes permettent de convertir un int en chaîne de caractère et inversement
	 */
	public String convertIntegerToString(int numberToConvert){
		return String.valueOf(numberToConvert);
	}
	public int convertStringToInteger(String stringToConvert){
		return Integer.parseInt(stringToConvert);
	}
	

	public static void main(String[] args) {
		
		/**
		 * Test de la méthode isStringValidNumber
		 */
		Part41 part41 = new Part41();
		
		String stringNumber = "99";
		String stringNotNumber = "quentin";
		
		if(part41.isStringValidNumber(stringNumber)){
			System.out.println(stringNumber +" est un nombre valide");
		}
		if(!part41.isStringValidNumber(stringNotNumber+" n'est pas un nombre valide."));
		
		/**
		 * Test de la méthode compareFloatsWithTolerence
		 */
		float f1 = 1.23f;
		float f2 = 1.24f;
		float f3 = 1.25f;
		float tolerance = 0.01f;
		
		if(part41.compareFloatsWithTolerence(f1, f2, tolerance)){
			System.out.println(f1+" et "+f2+" sont égaux avec une tolérence de "+tolerance);
		}
		if(!part41.compareFloatsWithTolerence(f1, f3, tolerance)){
			System.out.println(f1+" et "+f3+" ne sont pas égaux avec une tolérence de "+tolerance);
		}
		
		/**
		 * Test des méthodes de calculs mathématiques
		 */
		int number1 = 10;
		
		System.out.println(" Le cosinus de "+number1+" est : "+cos(number1));
		System.out.println(" Le sinus de "+number1+" est : "+sin(number1));
		System.out.println(" La tangente de "+number1+" est : "+tan(number1));
		System.out.println(" Le log de "+number1+" est : "+log(number1));
		System.out.println(" Random de Match : "+random());
		
		/**
		 * test de la méthode getPercentOfDouble
		 */
		double doubleNumber = 0.79;
		System.out.println(part41.getPercentOfDouble(doubleNumber));
		
		/**
		 * Test de la méthode printIntInBinaryOctalAndHexa
		 */
		int number = 74;
		part41.printIntInBinaryOctalAndHexa(number);
		
		/**
		 * Test de la méthode getRandomInt
		 */
		Random random = new Random();
		System.out.println(" int aléatoire : "+part41.getRandomInt(random, 100));
		System.out.println(" int aléatoire : "+part41.getRandomInt(random, 100));
		System.out.println(" int aléatoire : "+part41.getRandomInt(random, 100));
		
		/**
		 * Test des méthodes convertIntegerToString et convertStringToInteger
		 */
		//Part41 part41 = new Part41();
		int numbertoconvert = 7;
		String stringnumber = "99";
		String stringnotNumber = "quentin";
		
		System.out.println(part41.convertIntegerToString(numbertoconvert));
		System.out.println(part41.convertStringToInteger(stringnumber));
		System.out.println(part41.convertStringToInteger(stringnotNumber));
	}
}
