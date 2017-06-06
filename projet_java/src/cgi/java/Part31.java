package cgi.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Part31 {
	/**
	 * Prend en paramètre un tableau de chiffres non trié et un chiffre qui 
	 * est la valeur à trouver dans le tableau. Elle retourne l'index du 
	 * chiffre donné dans le tableau trié.
	 * @param tab
	 * @param valueToFind
	 * @return index
	 */
	public int FindValueInSortedTab (int[] tab, int valueToFind) {
		int[] myInts = tab;
		Arrays.sort(myInts);
		int index = Arrays.binarySearch(myInts, valueToFind);
		return index;
	}
	
	/**
	 * méthode qui permet de redimensionner un tableau. 
	 * La méthode retourne le tableau redimensionné
	 * @param myTab
	 * @param addSize
	 * @return myTab
	 */
	public int[] resizeTab (int[] myTab, int addSize) {
		int[] tmp = new int[myTab.length+addSize];
		System.arraycopy(myTab, 0, tmp, 0, myTab.length);
		myTab = tmp;
		return myTab;
	}
	
	/**
	 * méthode qui permet d'afficher une liste de chaîne de caractères 
	 * à l'aide d'une boucle for.
	 * @param listToPrint
	 */
	public void printListWithFor(List<String> listToPrint) {
		System.out.println("\nAffichage de la liste à l'aide d'une boucle for\n");
		for(String string: listToPrint){
			System.out.println(string);
		}
	}
	
	/**
	 * méthode qui permet d'afficher une liste de chaîne de caractères 
	 * à l'aide d'une boucle while.
	 * @param listToPrint
	 */
	public void printListWithWhile(List<String> listToPrint) {
		System.out.println("\nAffichage de la liste à l'aide d'une boucle while\n");
		Iterator<String> i = listToPrint.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
	
	/**
	 * deux méthodes qui permettent d'indiquer si une clé est présente dans le dictionnaire 
	 * et si une valeur figure dans le dictionnaire
	 * @param args
	 */
	public boolean isKeyInMap (Map<String,String> map, String key) {
		return map.containsKey(key);
	}
	
	public boolean isValueInMap (Map<String,String> map, String value) {
		return map.containsValue(value);
	}
	
	/**
	 * Méthode qui permet d'afficher une liste d'utilisateurs
	 */
	public void printListUser(List<userCollec> users){
		for(userCollec user: users){
			System.out.println(user);
		}
	}
	
	public static void main(String[] args) {
		/**
		 * Test de la méthode FindValueInSortedTab
		 */
		Part31 part31 = new Part31();
		int[] tab = {11,33,55,8,0,12};
		int index = part31.FindValueInSortedTab(tab, 33);
		System.out.println("33 se trouve à l'index"+index+" du tableau trié");
		
		/**
		 * Test de la méthode resizeTab
		 * 
		 */
		System.out.println(" taille tab avant redimension : "+tab.length);
		int[] resizeTab = part31.resizeTab(tab, 10);
		System.out.println(" taille tab après redimention : "+resizeTab.length);
		
		/**
		 * Test de la méthode printListWithFor
		 */
		List<String> names = new ArrayList<String>();
		names.add("quentin");
		names.add("grouleaud");
		names.add("périgueux");
		names.add("bordeaux");
		part31.printListWithFor(names);
		
		/**
		 * Test de la méthode printListWithWhile
		 */
		List<String> namesW = new ArrayList<String>();
		namesW.add("quentin");
		namesW.add("grouleaud");
		namesW.add("périgueux");
		namesW.add("bordeaux");
		part31.printListWithWhile(namesW);
		
		/**
		 * Implémentation d'un dictionnaire français anglais à l'aide d'une HashMap
		 */
		Map<String, String> dictionnary = new HashMap<String,String>();
		dictionnary.put("pomme","apple");
		dictionnary.put("banane","banana");
		dictionnary.put("kiwi","kiwi");
		dictionnary.put("poire","pear");
		dictionnary.put("fraise","strawberry");
		dictionnary.put("cerise","cherry");
		
		System.out.println("\nclés du dictionnaire\n");
		for(String key : dictionnary.values()) {
			System.out.println(key);
		}
		
		System.out.println("\nvaleurs du dictionnaire\n");
		for(String value : dictionnary.values()) {
			System.out.println(value);
		}
		
		System.out.println("\nclés/valeurs du dictionnaire\n");
		for(Entry<String, String>entry : dictionnary.entrySet()) {
			System.out.println("clé : "+entry.getKey()+" valeur : "+entry.getValue());
		}
		
		Set<String> keys = dictionnary.keySet();
		Iterator<String> ikey = keys.iterator();
		while(ikey.hasNext()){
			System.out.println(ikey.next());
		}
		
		/**
		 * Test des méthodes isKeyInMap et isValueeyInMap.
		 */
		if(part31.isKeyInMap(dictionnary, "pomme")){
			System.out.println("La clé pomme est dans le dictionnaire");
		}
		if(!part31.isKeyInMap(dictionnary, "toto")) {
			System.out.println("La clé toto n'est pas dans le dictionnaire");
		}
		if(part31.isValueInMap(dictionnary, "apple")){
			System.out.println("La valeur pomme est dans le dictionnaire");
		}
		if(!part31.isValueInMap(dictionnary, "titi")){
			System.out.println("La valeur titi n'est pas dans le dictionnaire");
		}
		
		/**
		 * Test de la classe userCollec
		 */
		userCollec user1 = new userCollec(8,"titi", "grosminet");
		userCollec user2 = new userCollec(10,"bipbip", "coyote");
		userCollec user3 = new userCollec(25,"wallace", "gromite");
		userCollec user4 = new userCollec(4,"bugs", "bunny");
		userCollec user5 = new userCollec(6,"daffy", "duck");
		
		List<userCollec> users = new ArrayList<userCollec>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		
		/**
		 * test qui permet d'afficher la liste avant tri puis après tri
		 */
		System.out.println("Liste d'users avant tri");
		part31.printListUser(users);
		
		Collections.sort(users, new userCollec());
		System.out.println("Liste d'users après tri");
		part31.printListUser(users);
	}
}
