package cgi.java;

import java.util.Enumeration;
import java.util.Properties;

/**
 * Classe permettant d'interagir avec l'environnement java
 * @author Formation
 *
 */
public class java_part1 {
	/**
	 * Méthode pour récupérer la valeur de la variable d'environnement PATH
	 * @return String contenu de la variable PATH
	 */

	public String getPath() {
		return System.getenv("PATH");
	}
	/**
	 * Méthode pour afficher les properties
	 */

	public void printProperties() {
		Properties props = System.getProperties();
		Enumeration<?> propertyNames = props.propertyNames();
		String key = "";
		while(propertyNames.hasMoreElements()){
			key = (String) propertyNames.nextElement();
			System.out.println(key+"= "+props.getProperty(key));
		}

	}
	/**
	 * Méthode qui permet d'affecter une valeur à une property donné
	 */

	public void setProperty(String property, String value) {
		System.setProperty(property, value);

	}
	/**
	 * Méthode qui permet de récupéré la valeur d'une propriété donné
	 */

	public String getProperty(String property){
		return System.getProperty(property);
	}
	
	public static void main(String[] args) {
		java_part1 part1 = new java_part1();
		String path = part1.getPath();

		System.out.println(" path : "+ path);
		part1.printProperties();
		part1.setProperty("zone", "EasternStandardTime");
		String valueOfProperty = part1.getProperty("zone");
		System.out.println("\nValeur de la property zone : "+valueOfProperty);
		
		String argument1 = args[0];
		String argument2 = args[1];
		
		System.out.println(" argument1 : "+argument1);
		System.out.println(" argument1 : "+argument2);
	}



}
