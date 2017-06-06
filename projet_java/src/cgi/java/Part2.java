package cgi.java;

import java.util.Stack;
import java.util.StringTokenizer;

public class Part2 {
	
	/**
	 * Méthode égalité boolean
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
	 * Méthode qui permet de vérifier l'égalité entre deux chaines de caractères 
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
	 * méthode qui retourne une chaine de caractère à l'envers
	 * @param chaine
	 * @return
	 */
	
	public String reverseStringByLetter(String chaine){
		StringBuilder sb = new StringBuilder(chaine);
		String reverseString = sb.reverse().toString();
		return reverseString;
	}
	
	/**
	 * Méthode retourne une chaine de caractère et transforme l'ordre des mots
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
	 * Méthode permettant de transformer la chaine de caractère en majuscule/minuscule/sans espaces
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
	 * Méthode qui prend une chaine de caractère et la retourne dans un tableau
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
		 * Test de la méthode boolean
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
		 * Test égalité chaine de caractère
		 */
		
		String s4 = "QUENTIN";
		if(!part2.testStringEquality(s1, s4)) {
			System.out.println(" Sans ignore case "+s1+" et "+s4+" ne sont pas identiques");
		}
		if(part2.testStringEqualityIgnoreCase(s1, s4)){
			System.out.println(" Avec ignore case "+s1+" et "+s4+" sont identiques");
		}
		
		/**
		 * Test méthode get order
		 */
		
		int order = part2.getOrderOfString(s1, s2);
		if(order < 0){
			System.out.println(s1+" est avant"+s2+" dans l'ordre alphabétique");
		}else if(order == 0){
			System.out.println(s1+" et "+s2+" sont identiques");
		}else if(order > 1){
			System.out.println(s1+" est après "+s2+" dans l'ordre alphabétique");
		}
		
		/**
		 * Test chaine de caractère à l'envers
		 */
		
		String reversedString = part2.reverseStringByLetter(s1);
		System.out.println(s1+" renversée ça donne : "+reversedString);
		
		/**
		 * Test Méthode mélenge de mot dans une chaine de caractère
		 */
		
		String s5 = "Quentin adore le dernier Mass effect andromeda";
		String mixedString= part2.reverseStringByWord(s5);
		System.out.println(s5+" mélangée ça donne : \n"+mixedString);
		
		/**
		 * Test méthode qui transforme la chaine de caractère en majuscule / minuscule / Sans espaces
		 */
		
		String upperString = part2.getUpperCaseString(s1);
		System.out.println(s1+" en majuscule ça done : "+upperString);
		
		String s6 = "CHOCOLAT";
		String lowerString = part2.getLowerCaseString(s6);
		System.out.println(s6+" en minuscule ça done : "+lowerString);
		
		String s7 = " toto ";
		String stringWithoutSpace = part2.getStringWithoutSpace(s7);
		System.out.println("Taille toto avec espace : "+s7.length());
		System.out.println(s7+" sans espace ça donne : "+stringWithoutSpace);
		System.out.println("Taille toto sans espace : "+stringWithoutSpace.length());
		
		/**
		 * Test mise en tableau d'une chaine de caractère 
		 */
		
		String s8 = "quentin,galiaure,developpeur,java,php,html";
		String[] results = part2.parseStringWithSeparator(s8, ",");
		System.out.println("taille du tableau résultat : "+results.length);
		System.out.println(s8+" à l'issue du split donne :");
		for (String result: results){
			System.out.println(result);
		}
		
		/**
		 * Test chaine de caractère transformer dans un tableau
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
