package cgi.java;

import java.util.Stack;
import java.util.StringTokenizer;

public class Part2 {
	
	/**
	 * M�thode �galit� boolean
	 * @return true
	 * @return false
	 */
	
	public boolean testStringEquality(String s1, String s2){
		if (s1.equals(s2)) {
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * M�thode qui permet de v�rifier l'�galit� entre deux chaines de caract�res 
	 * sans tenir compte de la case majuscule / minuscule
	 */
	
	public boolean testStringEqualityIgnoreCase(String s1, String s2){
		if(s1.equalsIgnoreCase(s2)){
			return true;
		}else{
			return false;
		}
	}
	
	public int getOrderOfString(String s1, String s2){
		return s1.compareTo(s2);
	}
	
	/**
	 * m�thode qui retourne une chaine de caract�re � l'envers
	 * @param chaine
	 * @return
	 */
	
	public String reverseStringByLetter(String chaine){
		StringBuilder sb = new StringBuilder(chaine);
		String reverseString = sb.reverse().toString();
		return reverseString;
	}
	
	/**
	 * M�thode retourne une chaine de caract�re et transforme l'ordre des mots
	 * @param args
	 */
	
	public String reverseStringByWord(String chaine){
		Stack<Object> stack = new Stack<Object>();
		StringTokenizer strTok = new StringTokenizer (chaine);
		while(strTok.hasMoreTokens()) {
			stack.push(strTok.nextElement());
		}
		StringBuilder reverseString = new StringBuilder();
		while(!stack.empty()){
			reverseString.append(stack.pop());
			reverseString.append(" ");
		}
		return reverseString.toString();
	}
	
	/**
	 * M�thode permettant de transformer la chaine de caract�re en majuscule/minuscule/sans espaces
	 */
	
	public String getUpperCaseString(String s){
		return s.toUpperCase();
	}
	public String getLowerCaseString(String s){
		return s.toLowerCase();
	}
	public String getStringWithoutSpace(String s){
		return s.trim();
	}
	
	/**
	 * M�thode qui prend une chaine de caract�re et la retourne dans un tableau
	 */
	
	public String[] parseStringWithSeparator (String s, String separator){
		return s.split(separator);
	}
	
	public void printStringCharByChar (String s){
		for(int i=0; i<s.length(); i++) {
			System.out.println(s.charAt(i));
		}
	}
	
	

	public static void main(String[] args) {
		
		/**
		 * Test de la m�thode boolean
		 */
		Part2 part2 = new Part2();
		String s1 = "quentin";
		String s2 = "galiaure";
		String s3 = "quentin";
		
		if(part2.testStringEquality(s1, s2)) {
			System.out.println( s1+" et "+s2+" sont identiques");
		}else{
			System.out.println( s1+" et "+s2+" ne sont pas identiques");
		}
		
		if(part2.testStringEquality(s1, s3)){
			System.out.println( s1+" et "+s3+" sont identiques");
		}else{
			System.out.println( s1+" et "+s3+" ne sont pas identiques");
		}
		
		/**
		 * Test �galit� chaine de caract�re
		 */
		
		String s4 = "QUENTIN";
		if(!part2.testStringEquality(s1, s4)) {
			System.out.println(" Sans ignore case "+s1+" et "+s4+" ne sont pas identiques");
		}
		if(part2.testStringEqualityIgnoreCase(s1, s4)){
			System.out.println(" Avec ignore case "+s1+" et "+s4+" sont identiques");
		}
		
		/**
		 * Test m�thode get order
		 */
		
		int order = part2.getOrderOfString(s1, s2);
		if(order < 0){
			System.out.println(s1+" est avant"+s2+" dans l'ordre alphab�tique");
		}else if(order == 0){
			System.out.println(s1+" et "+s2+" sont identiques");
		}else if(order > 1){
			System.out.println(s1+" est apr�s "+s2+" dans l'ordre alphab�tique");
		}
		
		/**
		 * Test chaine de caract�re � l'envers
		 */
		
		String reversedString = part2.reverseStringByLetter(s1);
		System.out.println(s1+" renvers�e �a donne : "+reversedString);
		
		/**
		 * Test M�thode m�lenge de mot dans une chaine de caract�re
		 */
		
		String s5 = "Quentin adore le dernier Mass effect andromeda";
		String mixedString= part2.reverseStringByWord(s5);
		System.out.println(s5+" m�lang�e �a donne : \n"+mixedString);
		
		/**
		 * Test m�thode qui transforme la chaine de caract�re en majuscule / minuscule / Sans espaces
		 */
		
		String upperString = part2.getUpperCaseString(s1);
		System.out.println(s1+" en majuscule �a done : "+upperString);
		
		String s6 = "CHOCOLAT";
		String lowerString = part2.getLowerCaseString(s6);
		System.out.println(s6+" en minuscule �a done : "+lowerString);
		
		String s7 = " toto ";
		String stringWithoutSpace = part2.getStringWithoutSpace(s7);
		System.out.println("Taille toto avec espace : "+s7.length());
		System.out.println(s7+" sans espace �a donne : "+stringWithoutSpace);
		System.out.println("Taille toto sans espace : "+stringWithoutSpace.length());
		
		/**
		 * Test mise en tableau d'une chaine de caract�re 
		 */
		
		String s8 = "quentin,galiaure,developpeur,java,php,html";
		String[] results = part2.parseStringWithSeparator(s8, ",");
		System.out.println("taille du tableau r�sultat : "+results.length);
		System.out.println(s8+" � l'issue du split donne :");
		for (String result: results){
			System.out.println(result);
		}
		
		/**
		 * Test chaine de caract�re transformer dans un tableau
		 */
		part2.printStringCharByChar(s1);
		
		String s9 = "galiaure@gmail.com";
		if(s9.contains("@")){
			System.out.println(s9+" est une adresse mail");
		}
		int index = s9.indexOf("@");
		String domain = s9.substring(index+1);
		System.out.println(" Le domaine du mail "+s9+" est "+domain);
		
		String s10 = "";
		if(s10.isEmpty()){
			System.out.println(s10+" est une chaine vide");
		}
	}
}
