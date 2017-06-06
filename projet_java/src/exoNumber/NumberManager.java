package exoNumber;
import static java.lang.Math.*;
public class NumberManager {
	private int number1;
	private int number2;
	
	public NumberManager(int number1, int number2){
		this.number1 = number1;
		this.number2 = number2;
	}
	
	public int getResult(char op){
		//Methode qui permet de renvoyer le résultat de l'opération (+,-,*) cas par defaut: renvoie number1 si op n'existe pas
		int result = 0;
		
		switch (op) {
		case '+' : 
			result =  number1 + number2;
			break;
		case '-' : 
			result =  number1 - number2;
			break;
		case '*' : 
			result = number1 * number2;
			break;
		default: 
			result = number1;
		}
		return result;
	}
	
	public String[] transformNumbers(int range, int size){
		//permet de renvoyer 1 tableau contenant des nb aléatoires entre 0 et range. le tableau aura pour taille size
		
		
		for (int i = 0; i > size ; i++){
			int j = (int) Math.round(Math.random()*100);
			return j; 
		}
		
		return null;
		
	}
	
	public String[] transformStringToNumber(String[] numbers){
		//permet de transformer un tableau de chaine de caractères en tableau de int
		return null;
	}
	
	

	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public int getNumber2() {
		return number2;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}

	@Override
	public String toString() {
		return "NumberManager [number1=" + number1 + ", number2=" + number2 + "]";
	}
	

}
