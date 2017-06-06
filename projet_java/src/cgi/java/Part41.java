package cgi.java;
import static java.lang.Math.*;

import java.text.NumberFormat;
import java.util.Random;
public class Part41 {
	
	/**
	 * m�thode qui permet de v�rifier si une cha�ne de caract�re est un nombre valide
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
	 * M�thode qui permet d'obtenir un int � partir d'un float
	 */
	public int arround(float number){
		return round(number);
	}
	
	/**
	 * m�thode qui permet de comparer deux floats en fonction d'une tol�rence
	 */
	public boolean compareFloatsWithTolerence(float f1,float f2, float tolerance){
		if (abs(f1-f2)<tolerance){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * m�thode qui permet d'obtenir un nombre en pourcentage
	 */
	public String getPercentOfDouble(double number){
		NumberFormat percentFormatter = NumberFormat.getPercentInstance();
		String percent = percentFormatter.format(number);
		return percent;
	}
	
	/**
	 * m�thode qui permet d'�crire la repr�sentation binaire, 
	 * hexadecimale et octale d'un int
	 */
	public void printIntInBinaryOctalAndHexa(int number){
		System.out.println(number+" en binaire donne: "+Integer.toBinaryString(number));
		System.out.println(number+" en octale donne: "+Integer.toOctalString(number));
		System.out.println(number+" en hexa donne: "+Integer.toHexString(number));
	}
	
	/**
	 * M�thode qui permet d'obtenir un int de mani�re al�atoire 
	 * dans un plage donn�e ex: 0 � 100
	 */
	public int getRandomInt(Random rn, int range){
		return rn.nextInt(range);
	}
	
	/**
	 * Les m�thodes permettent de convertir un int en cha�ne de caract�re et inversement
	 */
	public String convertIntegerToString(int numberToConvert){
		return String.valueOf(numberToConvert);
	}
	public int convertStringToInteger(String stringToConvert){
		return Integer.parseInt(stringToConvert);
	}
	

	public static void main(String[] args) {
		
		/**
		 * Test de la m�thode isStringValidNumber
		 */
		Part41 part41 = new Part41();
		
		String stringNumber = "99";
		String stringNotNumber = "quentin";
		
		if(part41.isStringValidNumber(stringNumber)){
			System.out.println(stringNumber +" est un nombre valide");
		}
		if(!part41.isStringValidNumber(stringNotNumber+" n'est pas un nombre valide."));
		
		/**
		 * Test de la m�thode compareFloatsWithTolerence
		 */
		float f1 = 1.23f;
		float f2 = 1.24f;
		float f3 = 1.25f;
		float tolerance = 0.01f;
		
		if(part41.compareFloatsWithTolerence(f1, f2, tolerance)){
			System.out.println(f1+" et "+f2+" sont �gaux avec une tol�rence de "+tolerance);
		}
		if(!part41.compareFloatsWithTolerence(f1, f3, tolerance)){
			System.out.println(f1+" et "+f3+" ne sont pas �gaux avec une tol�rence de "+tolerance);
		}
		
		/**
		 * Test des m�thodes de calculs math�matiques
		 */
		int number1 = 10;
		
		System.out.println(" Le cosinus de "+number1+" est : "+cos(number1));
		System.out.println(" Le sinus de "+number1+" est : "+sin(number1));
		System.out.println(" La tangente de "+number1+" est : "+tan(number1));
		System.out.println(" Le log de "+number1+" est : "+log(number1));
		System.out.println(" Random de Match : "+random());
		
		/**
		 * test de la m�thode getPercentOfDouble
		 */
		double doubleNumber = 0.79;
		System.out.println(part41.getPercentOfDouble(doubleNumber));
		
		/**
		 * Test de la m�thode printIntInBinaryOctalAndHexa
		 */
		int number = 74;
		part41.printIntInBinaryOctalAndHexa(number);
		
		/**
		 * Test de la m�thode getRandomInt
		 */
		Random random = new Random();
		System.out.println(" int al�atoire : "+part41.getRandomInt(random, 100));
		System.out.println(" int al�atoire : "+part41.getRandomInt(random, 100));
		System.out.println(" int al�atoire : "+part41.getRandomInt(random, 100));
		
		/**
		 * Test des m�thodes convertIntegerToString et convertStringToInteger
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
