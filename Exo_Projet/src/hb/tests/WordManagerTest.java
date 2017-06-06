package hb.tests;

import java.util.Scanner;

import hb.utils.WordManager;

public class WordManagerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordManager wm = new WordManager();
		Scanner sc = new Scanner (System.in);
		System.out.println("Saisir un mot: ");
		System.out.println(wm.reverseString(sc.nextLine()));
		
		System.out.println("Saisir un autre mot: ");
		System.out.println(wm.encodeStringStart0(sc.nextLine(),3));
		
		System.out.println("Saisir un autre mot: ");
		System.out.println(wm.encodeStringStart1(sc.nextLine(),3));
		
		
		sc.close();

	}
	
}
